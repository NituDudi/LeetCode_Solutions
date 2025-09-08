# 547 - Number of Provinces

## Problem Statement
There are `n` cities, some of which are connected directly, while others are connected indirectly through other cities. A province is a group of directly or indirectly connected cities and no other cities outside the group.  

You are given a square matrix `isConnected` where `isConnected[i][j] = 1` if the ith city and the jth city are directly connected, and `isConnected[i][j] = 0` otherwise.  

Return the total number of provinces.

---

## Approach
We use **Disjoint Set Union (DSU/Union-Find)** to group connected cities into components.

1. Initialize DSU with each city as its own parent.
2. Traverse the adjacency matrix `isConnected`.
   - If two cities `i` and `j` are connected, union them in DSU.
3. After processing, count how many nodes are their own parent → this gives the number of unique provinces.

---

## Data Structures Used
- **Array** (to keep track of parent and rank in DSU)
- **Disjoint Set Union (DSU)** (for efficient union and find operations)

---

## Intuition
Cities that are directly or indirectly connected should belong to the same group (province).  
Using **Union-Find**, we efficiently merge connected cities and count distinct groups at the end.
