# Torque and Development

Platform（平台）: HackerRank | https://www.hackerrank.com/contests/job-interview-medium/challenges/torque-and-development
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
