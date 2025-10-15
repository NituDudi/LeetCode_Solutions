class Pair {
    int u;
    int v;

    Pair(int u, int v) {
        this.u = u;
        this.v = v;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int rotten = 0;
        int fresh = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j));
                    rotten++;
                }
                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) {
            return 0;
        }

        if (rotten == 0) {
            return -1;
        }

        int min = -1;

        while (!q.isEmpty()) {
            int size = q.size();
            min++;

            for (int s = 0; s < size; s++) {
                Pair p = q.poll();
                int i = p.u;
                int j = p.v;

                if (j < n - 1 && grid[i][j + 1] == 1) { // right
                    grid[i][j + 1] = 2;
                    q.add(new Pair(i, j + 1));
                    fresh--;
                }

                if (j > 0 && grid[i][j - 1] == 1) { // left
                    grid[i][j - 1] = 2;
                    q.add(new Pair(i, j - 1));
                    fresh--;
                }

                if (i < m - 1 && grid[i + 1][j] == 1) { // down
                    grid[i + 1][j] = 2;
                    q.add(new Pair(i + 1, j));
                    fresh--;
                }

                if (i > 0 && grid[i - 1][j] == 1) { // up
                    grid[i - 1][j] = 2;
                    q.add(new Pair(i - 1, j));
                    fresh--;
                }
            }
        }

        if (fresh > 0) {
            return -1;
        }
        return min;
    }
}
