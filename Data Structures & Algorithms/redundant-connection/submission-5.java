class Solution {

    public class UnionFind {
        int n;
        int[] parent;
        int[] rank;
        public UnionFind(int n) {
            this.n = n;
            this.rank = new int[n + 1]; 
            this.parent = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }
        }


        public int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }


        public boolean union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px == py) {
                return false;
            }

            int rx = rank[px];
            int ry = rank[py];

            if (rx < ry) {
                parent[px] = py;
            } else if (ry < rx) {
                parent[py] = px;
            } else {
                parent[px] = py;
                rank[py]++;
            }
            return true;
        }


    }


    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            if (!uf.union(edge[0], edge[1])) {
                return edge;
            }
        }
        return new int[0];
    }
}
