# The Cheapest Cost of Roads and Libraries

平台：HackerRank  
难度：Medium  
分类：Graph / Connected Components / Greedy

---

## 一句话本质
> 这是一个 **无向图连通分量 + 成本最小化决策** 的问题。

---

## 识别信号（关键词）
- cities / roads
- reachable / accessible
- minimum cost

---

## 核心思路
1. 把城市和道路看成无向图
2. 每个连通分量至少需要一个图书馆
3. 在每个分量内，比较修路 vs 全建图书馆
4. 累加最小成本

---

## 解题模板
- DFS / BFS 找连通分量
- 对每个分量计算节点数
- 贪心选择更便宜的方案

---

## 易错点 / 坑
- library_cost <= road_cost 时，直接全建图书馆
- n=0 / n=1 的边界情况
- 成本求和必须用 long，避免溢出

---

## 复杂度
- 时间复杂度：O(n + m)
- 空间复杂度：O(n)

---

## 关联题 / 迁移
- Number of Islands
- Connected Components in Graph
