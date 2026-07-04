class Solution {

    private static final long INF = Long.MAX_VALUE;

    public long dijkstra(List<List<int[]>> adj, int n, int threshold) {
        long[] dist = new long[n];
        Arrays.fill(dist, INF);

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));

        dist[0] = 0;
        pq.offer(new long[]{0, 0});

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();

            int u = (int) cur[0];
            long d = cur[1];

            if (d != dist[u]) continue;

            for (int[] edge : adj.get(u)) {
                int v = edge[0];
                int w = edge[1];

                // Only allow edges whose cost >= threshold
                if (w < threshold) continue;

                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.offer(new long[]{v, dist[v]});
                }
            }
        }

        return dist[n - 1];
    }

    private boolean isPossible(List<List<int[]>> adj, int n, int threshold, long k) {
        return dijkstra(adj, n, threshold) <= k;
    }

    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;

        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            if (online[u] && online[v]) {
                adj.get(u).add(new int[]{v, w});
                low = Math.min(low, w);
                high = Math.max(high, w);
            }
        }

        if (low == Integer.MAX_VALUE) {
            return -1;
        }

        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(adj, n, mid, k)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
}