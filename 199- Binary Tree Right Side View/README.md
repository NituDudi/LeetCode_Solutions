# Leetcode Problem- 199- Right View of Binary Tree

## Problem Statement
Given the root of a binary tree, return the values of the nodes that are visible when the tree is viewed from the **right side**, from top to bottom.

---

## 🧠 Intuition

The **right view** of a binary tree consists of all nodes visible when the tree is viewed from the **right side**.

Think of standing to the right of the tree — at each level, you’ll only see the **last node** on that level.

---

## ⚙️ Approach

1. Perform a **Level Order Traversal (BFS)** using a **Queue**.
2. For each level, process all nodes and add **only the last node** to the result list.
3. This ensures that for every level, the node visible from the right is captured.

---

## 🧩 Data Structures Used

- **Queue<TreeNode>** → for level order traversal  
- **List<Integer>** → to store the final right view nodes  

---