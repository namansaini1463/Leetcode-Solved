class Solution {
    int[][] graph;
    boolean[] visited;
    boolean[] visiting;

    private boolean dfs(int node){ // Detects the cycle in the graph using DFS
        visiting[node] = true;

        for(int adjNode : graph[node]){
            if(!visited[adjNode]){
                if(visiting[adjNode]) return true;
                if(dfs(adjNode)) return true;
            } 
        }

        visiting[node] = false;
        visited[node] = true;

        return false; // No cycle detectedx
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        this.graph = graph;
        this.visited = new boolean[n];
        this.visiting = new boolean[n];

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(i);
            }
        }

        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < n; i++){
            if(!visiting[i]) result.add(i);
        }

        return result;
    }
}