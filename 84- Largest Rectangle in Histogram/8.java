import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        int max_area = 0;

        int leftsmall[] = leftsmallest(heights);
        int rightsmall[] = rightsmallest(heights);

        for (int i = 0; i < heights.length; i++) {
            int width = rightsmall[i] - leftsmall[i] - 1;
            int height = heights[i];

            int area = width * height;
            max_area = Math.max(max_area, area);
        }

        return max_area;
    }

    public int[] leftsmallest(int heights[]) {
        Stack<Integer> s = new Stack<>();
        int leftsmall[] = new int[heights.length];

        for (int i = 0; i < heights.length; i++) {
            while (!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                s.pop();
            }

            if (s.isEmpty()) {
                leftsmall[i] = -1;
            } else {
                leftsmall[i] = s.peek();
            }

            s.push(i);
        }

        return leftsmall;
    }

    public int[] rightsmallest(int heights[]) {
        Stack<Integer> s = new Stack<>();
        int rightsmall[] = new int[heights.length];

        for (int i = heights.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                s.pop();
            }

            if (s.isEmpty()) {
                rightsmall[i] = heights.length;
            } else {
                rightsmall[i] = s.peek();
            }

            s.push(i);
        }

        return rightsmall;
    }
}
