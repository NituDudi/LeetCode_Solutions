# 1143 - Longest Common Subsequence (LCS)

This repository contains three approaches to solve the Longest Common Subsequence problem using Java.

## Problem

Given two strings `text1` and `text2`, return the length of their longest common subsequence. A subsequence does not need to be contiguous.

---

## 1. Recursive Approach

Basic recursion where we compare characters from the end.

- If `n == 0` or `m == 0`, return 0  
- If last characters match → move diagonally  
- Else → take maximum of two recursive calls  

This approach explores all possibilities and recalculates the same subproblems multiple times.

---

## 2. Memoization (Top-Down DP)

Memoization stores results of subproblems to avoid recomputation.

- Use a 2D array `dp[n+1][m+1]` initialized with `-1`  
- If value already exists in `dp`, return it  
- Otherwise compute and store result  

This follows a top-down approach (large problem → smaller subproblems).

---

## 3. Tabulation (Bottom-Up DP)

Tabulation builds the solution iteratively.

- Create a 2D array `dp[n+1][m+1]`  
- `dp[i][j]` represents LCS of first `i` and `j` characters  
- Fill the table row by row  

Rules:
- If characters match → `dp[i][j] = 1 + dp[i-1][j-1]`  
- Else → `dp[i][j] = max(dp[i-1][j], dp[i][j-1])`  

This is an iterative approach with no recursion.

---