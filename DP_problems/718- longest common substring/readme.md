## Problem

Given two integer arrays `nums1` and `nums2`, return the length of the longest common subarray. The subarray must be continuous.

---

## Approach (Tabulation)

This solution uses a bottom-up dynamic programming approach.

- Create a 2D array `dp[n+1][m+1]`  
- `dp[i][j]` represents the length of the common subarray ending at index `i-1` in `nums1` and `j-1` in `nums2`  

---

## Logic

- If `i == 0` or `j == 0`, set `dp[i][j] = 0`  
- If elements match:
  - `dp[i][j] = 1 + dp[i-1][j-1]`  
- If elements do not match:
  - `dp[i][j] = 0`  

During iteration, keep updating a variable `ans` with the maximum value of `dp[i][j]`.

---