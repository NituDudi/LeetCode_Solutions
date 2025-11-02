# 11. Container With Most Water

## 🧩 Problem Statement  
Given an array **height**, where each element represents the height of a vertical line,  
find two lines that together with the x-axis form a container, such that the container holds the **maximum water**.

---

## 🚀 Approach  
- Use **two pointers** — one at the start (**lp**) and one at the end (**rp**).  
- Calculate the area between them as `min(height[lp], height[rp]) * (rp - lp)`.  
- Move the pointer pointing to the **smaller height** to try for a larger area.  
- Keep track of the **maximum area** found.  

---

## 💡 Intuition  
To maximize the area, we need to find a balance between **height** and **width**.  
Since width decreases when we move pointers, we must move the smaller line to try for a taller one.
