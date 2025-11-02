# 50. Pow(x, n)

## Problem Statement  
You are given two numbers — a double **x** and an integer **n**.  
Your task is to calculate **x raised to the power n** (that is, xⁿ).  
The value of **n** can be **positive**, **negative**, or **zero**.

---

## Approach  
1. **Base Case:**  
   If n = 0, return 1 because any number raised to the power 0 is 1.  

2. **Handle Negative Power:**  
   If n is negative, we convert it into a positive exponent by taking the reciprocal of x (x = 1/x) and making n = -n.  
   However, if n equals `Integer.MIN_VALUE` (−2³¹), we handle it carefully by adjusting with one extra multiplication to avoid overflow.  

3. **Recursive Power Calculation:**  
   - Divide the power into half: find **myPow(x, n/2)** recursively.  
   - If n is even, result = half * half.  
   - If n is odd, result = x * half * half.  

---

## Data Structures Used  
- **Recursion** (to divide the power computation into smaller subproblems)  

---

## Intuition  
Instead of multiplying x by itself n times, we use a **divide and conquer** strategy.  
By computing half powers recursively and combining them, we reduce time complexity from **O(n)** to **O(log n)**.  

---

### Example which can confuse you
- **Input:** x = 2.00000, n = -2147483648
   