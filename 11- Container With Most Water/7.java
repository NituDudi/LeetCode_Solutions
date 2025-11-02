class Solution {
    public int maxArea(int[] height) {
        // Two pointer approach
        int max_area = 0;
        int lp = 0;                          // left pointer
        int rp = height.length - 1;          // right pointer

        while (lp < rp) {
            int heights = Math.min(height[lp], height[rp]);
            int width = rp - lp;
            int area = heights * width;

            max_area = Math.max(max_area, area);

            // Move the pointer with the smaller height
            if (height[lp] < height[rp]) {
                lp++;
            } else {
                rp--;
            }
        }

        return max_area;
    }
}