# Torque and Development

Platform（平台）: HackerRank https://www.hackerrank.com/contests/job-interview-medium/challenges/torque-and-development
Difficulty（难度）: Medium  
Category（分类）: Graph（图论） / Connected Components（连通分量） / Greedy（贪心算法）

---

## One-sentence Essence（一句话本质）

> This is a **minimum cost problem（最小成本问题） on an undirected graph（无向图） using connected components（连通分量）**.

---

## Key Signals / Keywords（识别信号 / 关键词）

When you see these words, think **Graph + Connected Components（图 + 连通分量）**:

- cities（城市） → nodes（节点）  
- roads（道路） → edges（边）  
- connected / reachable（可达 / 连通）  
- build libraries（建图书馆）  
- minimum cost（最小成本）

---

## Problem Reframing（问题转化 / 模型化）

From story（故事） to model（模型）:

- City（城市） → **Graph Node（图节点）**  
- Road（道路） → **Undirected Edge（无向边）**  
- Access to library（能访问图书馆） → **Same Connected Component（同一连通分量）**  
- Minimize total cost（最小化总成本） → **Greedy decision per component（每个分量的贪心选择）**

---

## Core Insight（核心洞察 / 思路）

There are **two strategies（两种策略）**, choose the cheaper one（选最便宜的）:

### Case 1: `costRoad >= costLibrary`（修路比建图书馆贵或一样）

- Building roads（修路） is not worth it（不划算）  
- Build a library（建图书馆） in **every city（每个城市）**  
- Total cost（总成本） = `n * costLibrary`

### Case 2: `costRoad < costLibrary`（修路比建图书馆便宜）

- Use roads（修路） to connect cities（连接城市）  
- For **each connected component（每个连通分量）**:  
  - Build **1 library（一个图书馆）**  
  - Build `(componentSize - 1)` roads（修 componentSize-1 条路把分量连通）

---

## Cost Formula（成本公式）

For a connected component（连通分量） with `c` cities（c 个城市）:

cost = costLibrary + (c - 1) * costRoad

Total cost（总成本） = sum of all components’ cost（所有分量成本之和）

---

## Algorithm Strategy（解题策略）

1. Build an **adjacency list（邻接表）** for the graph（图）  
2. Use **DFS / BFS（深度/广度优先搜索）** to find connected components（找连通分量）  
3. For each unvisited node（每个未访问节点）:  
   - Traverse the component（遍历分量）  
   - Count its size（统计分量节点数）  
   - Apply the cost formula（计算成本）

---

## Pseudocode（伪代码）

```text
if costRoad >= costLibrary:
    return n * costLibrary  # 每个城市直接建图书馆

visited = boolean[n]
totalCost = 0

for each city i:
    if not visited[i]:
        componentSize = DFS(i)  # DFS 遍历分量并返回节点数
        totalCost += costLibrary + (componentSize - 1) * costRoad

return totalCost
```

## Common Pitfalls（常见坑 / 易错点）

- ⚠ Forgetting the special case: costRoad >= costLibrary（忘记处理修路太贵的情况）

- ⚠ Isolated cities（孤立城市） are also connected components（也是连通分量）

- ⚠ Use long（用 long） for total cost（总成本），avoid integer overflow（避免整数溢出）

- ⚠ City indices（城市编号） are usually 1-based（通常从 1 开始）， convert to 0-based（需要减 1）

## Time & Space Complexity（时间与空间复杂度）

- Time Complexity（时间复杂度）: O(n + m)

- Space Complexity（空间复杂度）: O(n + m)

Where（其中）:

- n = number of cities（城市数 / 节点数）

- m = number of roads（道路数 / 边数）

## Interview Takeaway（面试带走点）

- This is a classic Connected Components problem（经典连通分量问题）

- Key decision（关键决策）: road vs library cost comparison（修路 vs 建图书馆成本比较）

- Very common in system design flavored graph questions（系统设计风格图论题）

## Related Problems（关联题 / 可迁移题）

- Roads and Libraries（同逻辑题）

- Number of Islands（岛屿计数 / 连通分量）

- Count Connected Components in Undirected Graph（统计无向图连通分量）