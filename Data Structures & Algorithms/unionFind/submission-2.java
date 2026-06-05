class UnionFind {
    int[] parent;
    int[] rank;
    int component;
    public UnionFind(int n) {
        this.rank = new int[n + 1];
        this.parent = new int[n + 1];
        this.component = n;
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

    public boolean isSameComponent(int x, int y) {
        return find(x) == find(y); 
    }

    public boolean union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px == py) {
            return false;
        }

        int rx = rank[px];
        int ry = rank[py];

        if (rx > ry) {
            parent[py] = px;
        } else if (rx < ry) {
            parent[px] = py;
        } else {
            parent[px] = py;
            rank[py]++;
        }
        this.component--;
        return true;
    }

    public int getNumComponents() {
        return component;
    }
}
