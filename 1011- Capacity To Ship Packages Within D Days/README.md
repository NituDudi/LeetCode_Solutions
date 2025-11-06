# Leetcode problem - 1011 -  Ship Packages Within D Days

## 📖 Problem Statement
You are given an array `weights` representing the weights of packages on a conveyor belt, and an integer `days` representing the number of days within which all packages must be shipped.

You must determine the **minimum ship capacity** needed to deliver all packages within the given number of days.  
Each package must be shipped **in order**, and the total weight shipped in a day **cannot exceed** the ship’s capacity.

---

## 💡 Approach

- The **minimum capacity** of the ship must be **at least** the heaviest package.
- The **maximum capacity** can be the **sum of all package weights** (if shipped all in one day).
- We use **binary search** between these two limits to find the smallest valid capacity.

### Steps:
1. Use binary search on the range `[max(weights), sum(weights)]`.
2. For each mid-value (possible capacity), check how many days are needed to ship all packages.
3. If it’s possible within `days`, try a smaller capacity.
4. Otherwise, increase the capacity.
5. The final answer is the smallest ship capacity that satisfies the condition.

---

## 🧩 Helper Function

The `helper()` function simulates the shipping process for a given capacity:
- It keeps adding package weights until the capacity is exceeded.
- When exceeded, it moves to the next day.
- It returns `true` if all packages can be shipped within the allowed number of days.

---
