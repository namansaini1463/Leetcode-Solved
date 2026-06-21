class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adj.get(u).add(new int[]{v, w});
        }

        long INF = Long.MAX_VALUE;

        // dis[node][streak]
        long[][] dist = new long[n][k+1];

        for(int i = 0; i < n; i++){
            Arrays.fill(dist[i], INF);
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        pq.offer(new long[]{0, 0, 1}); // cost, node, streak
        dist[0][1] = 0;

        while(!pq.isEmpty()){
            long[] current = pq.poll();

            long cost = current[0];
            int u = (int)current[1];
            int streak = (int)current[2];

            if(u == n-1) return (int)cost;

            for(int[] next : adj.get(u)){
                int v = next[0];
                int wt = next[1];

                int newStreak = 1;

                if(labels.charAt(v) == labels.charAt(u)) newStreak = streak + 1;

                if(newStreak > k) continue;

                long newCost = cost + wt;

                if(newCost < dist[v][newStreak]){
                    dist[v][newStreak] = newCost;
                    pq.offer(new long[]{newCost, v, newStreak});
                }
            }
        }

        return -1;
    }
}