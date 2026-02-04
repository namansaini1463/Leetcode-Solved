class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        int[] minimumDistance = new int[n + 1];
        Arrays.fill(minimumDistance, Integer.MAX_VALUE);
        minimumDistance[1] = 0;

        int[] secondMinimumDistance = new int[n + 1];
        Arrays.fill(secondMinimumDistance, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[] { 0, 1 }); // {distance, node}

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            // If the current time/distance is even, then I am free to move to the next node.
            // else, i have to wait until the signal toggles, so that i can move. The wait time would be the below formula
            int d = (curr[0] / change) % 2 == 0 ? curr[0] : ((curr[0] / change) + 1) * change;
            int node = curr[1];

            if (node == n && secondMinimumDistance[node] != Integer.MAX_VALUE)
                return secondMinimumDistance[node];

            for (int adj : adjList.get(node)) {
                if (d + time < minimumDistance[adj]) {
                    secondMinimumDistance[adj] = minimumDistance[adj];
                    minimumDistance[adj] = d + time;
                    pq.add(new int[] { d + time, adj });
                } else if (d + time < secondMinimumDistance[adj] && d + time > minimumDistance[adj]) {
                    secondMinimumDistance[adj] = d + time;
                    pq.add(new int[] { d + time, adj });
                }
            }
        }

        return -1;
    }
}