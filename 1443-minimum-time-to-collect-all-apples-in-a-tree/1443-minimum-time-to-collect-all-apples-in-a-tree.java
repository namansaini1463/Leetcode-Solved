class Solution {
    private int dfs(int node, int parent, List<List<Integer>> adj, List<Boolean> hasApple){
        int time = 0;

        for(int adjNode : adj.get(node)){
            if(adjNode != parent){
                int childTime = dfs(adjNode, node, adj, hasApple);

                if(childTime > 0 || hasApple.get(adjNode)) time += childTime + 2;
            }
        }

        return time;
    }

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int u = edge[0], v = edge[1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int minimumTime = dfs(0, -1, adj, hasApple);

        return minimumTime;

    }
}