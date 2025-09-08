class DSU {
    int par[];
    int rank[];

    DSU(int n) {
        par = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            par[i] = i;
        }
    }

    public int find(int x) {
        if (par[x] == x) {
            return x;
        }
        return par[x] = find(par[x]);
    }

    public void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);

        if (rank[parA] == rank[parB]) {
            par[parA] = parB;
            rank[parB]++;
        } else if (rank[parA] > rank[parB]) {
            par[parB] = parA;
        } else {
            par[parA] = parB;
        }
    }
}

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        DSU dsu = new DSU(n + 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    dsu.union(i + 1, j + 1);
                }
            }
        }

        int unique_comp = 0;
        for (int i = 1; i <= n; i++) {
            int par = dsu.find(i);
            if (par == i) {
                unique_comp++;
            }
        }

        return unique_comp;
    }
}
