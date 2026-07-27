class Solution {

    List<List<Integer>> graph = new ArrayList<>();
    boolean[] visited;

    public boolean validPath(int n, int[][] edges, int source, int destination) {

        // Build graph
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        visited = new boolean[n];

        return dfs(source, destination);
    }

    private boolean dfs(int node, int destination) {

        if (node == destination) {
            return true;
        }

        visited[node] = true;

        for (int neighbor : graph.get(node)) {

            if (!visited[neighbor]) {

                if (dfs(neighbor, destination)) {
                    return true;
                }

            }
        }

        return false;
    }
}