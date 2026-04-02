class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        List<Set<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new HashSet<>());
        }

        int[] indegree = new int[n];

        for(int[] road : roads){
            int u = road[0], v = road[1];

            indegree[u]++; indegree[v]++;

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int maxNetworkRank = 0;

        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                maxNetworkRank = Math.max(maxNetworkRank, indegree[i] + indegree[j] - (adj.get(i).contains(j) ? 1 : 0));
            }
        }

        return maxNetworkRank;
        
        
    }
}