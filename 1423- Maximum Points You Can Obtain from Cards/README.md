# 1423 - Maximum Points You Can Obtain from Cards

## 📖 Problem Statement
You are given an integer array `cardPoints` and an integer `k`.  
Each element in `cardPoints` represents the points of a card placed in a row.

You can take **exactly `k` cards** from either the beginning or the end of the row.  
Your goal is to **maximize** the total points you can obtain.

---

## 💡 Approach

Instead of directly choosing `k` cards, we can think of the problem in reverse:
- You are **leaving behind `n - k` cards** in the middle.
- To maximize the score, you need to **minimize the sum** of the `n - k` contiguous cards that are *not taken*.

### Steps:
1. Calculate the total sum of all cards.
2. Use a **sliding window** of size `n - k` to find the **minimum sum subarray**.
3. Subtract this minimum sum from the total to get the **maximum points**.

---

## Key Insight
This problem is a great example of using **complementary subarray logic**:
Instead of finding the *best k cards*, we find the *worst (n - k) cards* to leave behind.

---