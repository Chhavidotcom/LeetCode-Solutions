class Solution {
    public int countCompleteComponents(int n, int[][] edges) {

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int ans = 0;

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {

                int[] result = dfs(graph, visited, i);

                int vertices = result[0];
                int edgesCount = result[1] / 2;

                if (edgesCount == vertices * (vertices - 1) / 2) {
                    ans++;
                }
            }
        }

        return ans;
    }

    int[] dfs(List<List<Integer>> graph, boolean[] visited, int node) {

        visited[node] = true;

        int vertices = 1;
        int edges = graph.get(node).size();

        for (int neighbour : graph.get(node)) {

            if (!visited[neighbour]) {

                int[] result = dfs(graph, visited, neighbour);

                vertices += result[0];
                edges += result[1];
            }
        }

        return new int[]{vertices, edges};
    }
}