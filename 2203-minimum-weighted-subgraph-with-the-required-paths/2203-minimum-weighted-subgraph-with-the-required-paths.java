class Solution {
    // private void addOrUpdateEdge(List<List<int[]>> adjList, int[] newEdge) {
    //     int u = newEdge[0];
    //     int v = newEdge[1];
    //     int w = newEdge[2];

    //     for (int[] edge : adjList.get(u)) {
    //         if (edge[0] == v) {
    //             edge[1] = Math.min(edge[1], w);
    //             return;
    //         }
    //     }

    //     adjList.get(u).add(new int[] { v, w });
    // }

    private long[] dijkstra(int n, List<List<int[]>> adjList, int source) {
        long[] distance = new long[n];
        Arrays.fill(distance, Long.MAX_VALUE);
        distance[source] = 0;

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.add(new long[] { 0, source });

        while (!pq.isEmpty()) {
            long[] top = pq.poll();
            long d = top[0];
            int node = (int) top[1];

            if (d > distance[node])
                continue;

            for (int[] edge : adjList.get(node)) {
                int nei = edge[0];
                int cost = edge[1];

                if (d + cost < distance[nei]) {
                    distance[nei] = d + cost;
                    pq.add(new long[] { d + cost, nei });
                }

            }
        }

        return distance;

    }

    public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
        // Building the adjList 
        List<List<int[]>> graph = new ArrayList<>();
        List<List<int[]>> reversedGraph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            reversedGraph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            // Normal Graph
            graph.get(u).add(new int[] { v, w });

            // Reversed Graph
            reversedGraph.get(v).add(new int[] { u, w });
        }

        long[] distance_src1 = dijkstra(n, graph, src1);
        long[] distance_src2 = dijkstra(n, graph, src2);
        long[] distance_dest_to_intermediate = dijkstra(n, reversedGraph, dest);

        long minWeight = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (distance_src1[i] == Long.MAX_VALUE || distance_src2[i] == Long.MAX_VALUE
                    || distance_dest_to_intermediate[i] == Long.MAX_VALUE)
                continue;
            minWeight = Math.min(minWeight, distance_src1[i] + distance_src2[i] + distance_dest_to_intermediate[i]);

        }

        // System.out.println(Arrays.toString(distance_src1));
        // System.out.println(Arrays.toString(distance_src2));
        // System.out.println(Arrays.toString(distance_dest_to_intermediate));

        // for(int i = 0; i < n; i++){
        //     System.out.println("Processing: " + i);
        //     for(int[] edge : graph.get(i)) System.out.println(Arrays.toString(edge));
        //     System.out.println();
        //     for(int[] edge : reversedGraph.get(i)) System.out.println(Arrays.toString(edge));
        //     System.out.println();
        // }

        return (minWeight == Long.MAX_VALUE) ? -1 : minWeight;
    }
}