class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>(); // node -> (adj, cost), (adj, cost)
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] flight : flights){
            int source = flight[0], dest = flight[1], cost = flight[2];

            adj.get(source).add(new int[]{dest, cost});
        }


        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        pq.offer(new int[]{0, 0, src}); // {stops, distance, node}

        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);

        while(!pq.isEmpty()){
            int[] front = pq.poll();

            int stops = front[0], d = front[1], node = front[2];

            if(stops <= k){
                for(int[] edge : adj.get(node)){
                    int adjNode = edge[0], cost = edge[1];

                    if(d + cost < distance[adjNode]){
                        distance[adjNode] = d + cost;
                        pq.offer(new int[]{stops+1, distance[adjNode], adjNode});
                    }
                }
            }
        }

        return distance[dst] == Integer.MAX_VALUE ? -1 : distance[dst];
    }
}