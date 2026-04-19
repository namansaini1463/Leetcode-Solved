class Solution {
    public int[] values;
    public int k;

    private int dfs(int node, List<List<Integer>> adj, int[] components, boolean[] visited){
        visited[node] = true;

        long sumAtNode = 0;

        for(int adjNode : adj.get(node)){
            if(!visited[adjNode])
                sumAtNode += dfs(adjNode, adj, components, visited);
        }

        sumAtNode += values[node];

        if(sumAtNode % k == 0){
            components[0]++;
            return 0;
        }

        return (int)(sumAtNode % k);
        
    }
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        this.values = values;
        this.k = k;

        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for(int[] edge : edges){
            int u = edge[0], v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] components = new int[1];

        boolean[] visited = new boolean[n];

        // 0 is the root node
        dfs(0, adj, components, visited);

        return components[0];
    }
}