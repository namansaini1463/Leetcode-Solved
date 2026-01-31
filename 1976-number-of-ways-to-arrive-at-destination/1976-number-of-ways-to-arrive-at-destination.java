class Solution {
    private static final int MOD = 1_000_000_007;

    public int countPaths(int n, int[][] roads) {
        // Build the adjacency list 
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] road : roads){
            int u = road[0];
            int v = road[1];
            int w = road[2];

            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
        }

        int ways[] = new int[n];
        Arrays.fill(ways, 0);

        long dist[] = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        ways[0] = 1; dist[0] = 0; // Inititalize the source node

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.add(new long[]{0, 0}); // {distance, node};

        while(!pq.isEmpty()){
            long[] top = pq.poll();
            long d = top[0];
            int node = (int)top[1];

            if(d > dist[node]) continue;

            for(int[] adjEdge : adj.get(node)){
                int edgeWeight = adjEdge[1];
                int nei = adjEdge[0];

                if(d + edgeWeight < dist[nei]){
                    dist[nei] = d + edgeWeight;
                    pq.add(new long[]{d + edgeWeight, nei});
                    ways[nei] = ways[node];
                } else if(d + edgeWeight == dist[nei]){
                    ways[nei] = ((ways[nei] % MOD) + (ways[node] % MOD)) % MOD;
                }

            }
        }

        System.out.println(Arrays.toString(ways));
        System.out.println(Arrays.toString(dist));

        return ways[n-1];

    }
}



















