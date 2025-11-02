class Solution {
    public int trap(int[] height) {
        // trapped_water = water_level - height_of_block
        // water_level = height * width; width = 1, height = min(left_max, right_max)

        int n = height.length;
        int total = 0;

        // Step 1: Calculate left maximum for each index
        int left_max[] = new int[n];
        left_max[0] = height[0];
        for (int i = 1; i < n; i++) {
            left_max[i] = Math.max(left_max[i - 1], height[i]);
        }

        // Step 2: Calculate right maximum for each index
        int right_max[] = new int[n];
        right_max[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right_max[i] = Math.max(right_max[i + 1], height[i]);
        }

        // Step 3: Calculate trapped water
        for (int i = 0; i < n; i++) {
            int heights = Math.min(left_max[i], right_max[i]);
            int trapped_water = heights - height[i];
            int width = 1;
            int area = width * trapped_water;
            total += area;
        }

        return total;
    }
}
