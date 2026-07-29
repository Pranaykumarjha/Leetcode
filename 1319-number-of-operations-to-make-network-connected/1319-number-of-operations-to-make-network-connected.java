class Solution {

    int[] parent;
    int[] rank;
    int count;

    public int makeConnected(int n, int[][] connections) {

        if (connections.length < n - 1)
            return -1;

        parent = new int[n];
        rank = new int[n];
        count = n;

        for (int i = 0; i < n; i++)
            parent[i] = i;

        int extraEdges = 0;

        for (int[] edge : connections) {

            int u = edge[0];
            int v = edge[1];

            if (find(u) == find(v)) {
                extraEdges++;
            } else {
                union(u, v);
            }
        }

        if (extraEdges >= count - 1)
            return count - 1;

        return -1;
    }

    private int find(int x) {

        if (parent[x] != x)
            parent[x] = find(parent[x]);

        return parent[x];
    }

    private void union(int x, int y) {

        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY)
            return;

        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }

        count--;
    }
}