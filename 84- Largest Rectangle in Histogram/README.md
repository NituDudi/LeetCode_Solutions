# Largest Rectangle in a Histogram

## 💡 Explanation
For each bar, find the nearest smaller element on the left and right using stacks.  
The width of the rectangle is `(rightSmall[i] - leftSmall[i] - 1)`, and area = `height[i] * width`.  
Track the maximum area for all bars.