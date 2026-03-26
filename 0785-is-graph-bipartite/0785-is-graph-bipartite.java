class Solution {
    private boolean checkBipartiteDFS(int node, int color, int[] colors, int[][] adj){
        colors[node] = color;

        for(int adjNode : adj[node]){
            if(colors[adjNode] == -1){
                if(!checkBipartiteDFS(adjNode, 1 - color, colors, adj)) return false;
            } else if(colors[adjNode] == colors[node]) return false;
        }

        return true;
    }

    public boolean isBipartite(int[][] adj) {
        int n = adj.length;

        int[] visited = new int[n];
        Arrays.fill(visited, -1);
        

        for(int i = 0; i < n; i++){
            if(visited[i] == -1)
                if(!checkBipartiteDFS(i, 0, visited, adj)) return false;
        }

        return true;
    }
}