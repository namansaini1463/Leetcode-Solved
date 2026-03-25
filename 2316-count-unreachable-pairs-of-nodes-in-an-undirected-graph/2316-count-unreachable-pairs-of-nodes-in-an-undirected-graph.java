class Solution {
    private long dfs(int node, boolean[] visited, List<List<Integer>> adj){
        if(visited[node]) return 0;

        visited[node] = true;

        int nodesCount = 1;
        
        for(int adjNode : adj.get(node)){
            nodesCount += dfs(adjNode, visited, adj);
        }

        return nodesCount;
    }

    public long countPairs(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0], v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[n];

        List<Long> count = new ArrayList<>();
        long totalCount = 0;

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                long nodesCount = dfs(i, visited, adj);
                count.add(nodesCount);
                totalCount += nodesCount;
            }
        }

        long sumOfSquares = 0;
        long wholeSquare = totalCount * totalCount;
        for(long c : count){
            sumOfSquares += c*c;
        }

        // System.out.println(count);
        // System.out.println(totalCount + " " + wholeSquare);
        // System.out.println(sumOfSquares);

        return (wholeSquare - sumOfSquares) / 2;

    }
}