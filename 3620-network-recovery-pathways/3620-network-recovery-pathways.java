import java.util.*;

class Solution {
    int n;

    public boolean find(int limit, List<List<int[]>> adj,
                        boolean[] online, long k){

        PriorityQueue<long[]> pq =
            new PriorityQueue<>((a,b) -> Long.compare(a[0], b[0]));

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        pq.offer(new long[]{0,0});

        while(!pq.isEmpty()){
            long[] curr = pq.poll();

            long currCost = curr[0];
            int node = (int) curr[1];

            if(currCost > dist[node]) continue;

            for(int[] nxt : adj.get(node)){
                int nxtNode = nxt[0];
                int cst = nxt[1];

                if(cst < limit) continue;
                if(nxtNode != n-1 && !online[nxtNode]) continue;

                long newCost = currCost + cst;

                if(newCost < dist[nxtNode]){
                    dist[nxtNode] = newCost;
                    pq.offer(new long[]{newCost, nxtNode});
                }
            }
        }

        return dist[n-1] <= k;
    }

    public int findMaxPathScore(int[][] edges, boolean[] online, long k){
        n = online.length;

        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        int low = Integer.MAX_VALUE;
        int high = 0;

        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            int cst = e[2];

            adj.get(u).add(new int[]{v,cst});

            low = Math.min(low,cst);
            high = Math.max(high,cst);
        }

        int res = -1;

        while(low <= high){
            int mid = low + (high-low)/2;

            if(find(mid,adj,online,k)){
                res = mid;
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }

        return res;
    }
}