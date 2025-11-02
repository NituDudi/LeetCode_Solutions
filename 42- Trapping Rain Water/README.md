# 42. Trapping Rain Water

## 🧩 Problem Statement  
Given an array **height** where each element represents the height of a bar,  
calculate how much **rainwater** can be trapped between the bars after it rains.

---

## 🚀 Approach  
1. **Left Max & Right Max:**  
   - For every index, calculate:
     - `left_max[i]` → the tallest bar to the left.
     - `right_max[i]` → the tallest bar to the right.
2. **Water Above Each Block:**  
   - Water trapped on top of block `i` = `min(left_max[i], right_max[i]) - height[i]`.
3. **Total Water:**  
   - Sum up the trapped water for all indices.

This approach ensures we efficiently find the water trapped above each block using precomputed arrays.

---

## 💡 Intuition  
The water above a bar depends on the **shorter** of the tallest bars on its **left and right**.  
We precompute these maximums to quickly calculate trapped water at each position.
