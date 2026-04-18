class Solution {
    public final int INF = (int)1e9;

    private int dijkstra(int n, int source, int destination, List<List<int[]>> adj){
        int[] distance = new int[n];
        Arrays.fill(distance, INF);
        distance[source] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{source, 0});

        while(!pq.isEmpty()){
            int[] front = pq.poll();
            int node = front[0], dist = front[1];

            if(distance[node] < dist) continue;

            if(node == destination) return dist;

            for(int[] next : adj.get(node)){
                int adjNode = next[0], wt = next[1];

                if(dist + wt < distance[adjNode]){
                    distance[adjNode] = dist + wt;
                    pq.offer(new int[]{adjNode, distance[adjNode]});
                }
            }
        }

        return INF;
    }

    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int u = edge[0], v = edge[1], w = edge[2];

            if(w != -1){
                adj.get(u).add(new int[]{v, w});
                adj.get(v).add(new int[]{u, w});
            }
        }

        int mimimumCostWithFixedEdges = dijkstra(n, source, destination, adj);

        if(mimimumCostWithFixedEdges < target) {
            return new int[0][0];
        } 
        
        boolean matched = (mimimumCostWithFixedEdges == target);

        for(int[] edge : edges){ 
            int u = edge[0], v = edge[1], w = edge[2];

            if(w == -1){
                if(matched){
                    edge[2] = INF;
                }
                

                adj.get(u).add(new int[]{v, 1});
                adj.get(v).add(new int[]{u, 1});
                edge[2] = 1;

            
                int minimumCostWithDynamicEdges = dijkstra(n, source, destination, adj);

                if(minimumCostWithDynamicEdges <= target){
                    matched = true;
                    edge[2] += target - minimumCostWithDynamicEdges;
                }
            }

        }

        return matched ? edges : new int[0][0];
    }
}