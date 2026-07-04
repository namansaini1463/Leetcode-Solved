class Solution {
    public final int INF = Integer.MAX_VALUE;
    public int minScore(int n, int[][] roads) {
        List<List<int[]>> adj = new ArrayList<>();

        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] road : roads){
            int u = road[0], v = road[1], w = road[2];

            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
        }

        boolean[] visited = new boolean[n + 1];

        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{1, INF});

        int minimumScore = INF;

        while(!q.isEmpty()){
            int[] top = q.poll();

            int currentNode = top[0];
            int currentMinimum = top[1];

            for(int[] adjNode : adj.get(currentNode)){
                int nextNode = adjNode[0];
                int nextCost = adjNode[1];

                minimumScore = Math.min(minimumScore, nextCost);
                
                if(!visited[nextNode]){
                    q.offer(new int[]{nextNode, Math.min(currentMinimum, nextCost)});
                    visited[nextNode] = true;
                }
            }
        }

        return minimumScore;


    }
}