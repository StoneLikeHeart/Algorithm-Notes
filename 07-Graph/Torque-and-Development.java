import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'roadsAndLibraries' function below.
     *
     * The function is expected to return a LONG_INTEGER（返回 long 类型）.
     * The function accepts following parameters（参数列表）:
     *  1. INTEGER n             -> 城市数
     *  2. INTEGER c_lib         -> 建图书馆的费用
     *  3. INTEGER c_road        -> 修道路的费用
     *  4. 2D_INTEGER_ARRAY cities -> 道路信息（每条道路连接两个城市）
     */

    public static long roadsAndLibraries(int n, int c_lib, int c_road, List<List<Integer>> cities) {
        // 如果建图书馆比修路便宜或者一样，直接每个城市建图书馆
        if (c_lib <= c_road) {
            return (long) n * c_lib; // long 避免溢出
        }

        // ----------- 构建图（邻接表） -----------
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // 将道路信息转为无向图
        for (List<Integer> road : cities) {
            int u = road.get(0) - 1; // 城市编号从1开始，转成0-based
            int v = road.get(1) - 1;
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // ----------- DFS 遍历连通分量 -----------
        boolean[] visited = new boolean[n];
        long totalCost = 0; // 总成本

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                // 对每个未访问的节点，计算连通分量大小
                long componentSize = dfs(graph, visited, i);
                // 成本 = 一个图书馆 + (分量大小 - 1)条路
                totalCost += c_lib + (componentSize - 1) * c_road;
            }
        }

        return totalCost;
    }

    // DFS 返回连通分量节点数量
    private static long dfs(List<List<Integer>> graph, boolean[] visited, int node) {
        visited[node] = true;
        long size = 1; // 当前节点算一个
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                size += dfs(graph, visited, neighbor);
            }
        }
        return size;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = Integer.parseInt(bufferedReader.readLine().trim()); // 测试用例数量

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]); // 城市数
                int m = Integer.parseInt(firstMultipleInput[1]); // 道路数
                int c_lib = Integer.parseInt(firstMultipleInput[2]); // 图书馆费用
                int c_road = Integer.parseInt(firstMultipleInput[3]); // 道路费用

                List<List<Integer>> cities = new ArrayList<>();

                // 读取道路信息，每条道路连接两个城市
                IntStream.range(0, m).forEach(i -> {
                    try {
                        cities.add(
                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                // 调用函数计算最小成本
                long result = Result.roadsAndLibraries(n, c_lib, c_road, cities);

                // 输出
                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
