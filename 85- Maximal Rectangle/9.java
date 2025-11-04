import java.util.Stack;

class Solution {
    public int maximalRectangle(char[][] matrix) {
        int height[][] = new int[matrix.length][matrix[0].length];

        // Step 1: Build the height matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                char ch = matrix[i][j];
                if (ch == '1') {
                    if (i != 0) {
                        height[i][j] = 1 + height[i - 1][j];
                    } else {
                        height[i][j] = 1;
                    }
                } else {
                    height[i][j] = 0;
                }
            }
        }

        // Step 2: For each row, calculate the largest rectangle area
        int max_area = 0;

        for (int i = 0; i < matrix.length; i++) {
            int heights[] = height[i];
            int leftsmall[] = leftsmallest(heights);
            int rightsmall[] = rightsmallest(heights);

            for (int j = 0; j < matrix[0].length; j++) {
                int width = rightsmall[j] - leftsmall[j] - 1;
                int h = height[i][j];

                int area = width * h;
                max_area = Math.max(max_area, area);
            }
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
