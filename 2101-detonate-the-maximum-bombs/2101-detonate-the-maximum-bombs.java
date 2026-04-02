class Solution {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;

        // Directed graph, which stores which bomb can detonate which other bomb
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                int x1 = bombs[i][0], y1 = bombs[i][1], r1 = bombs[i][2];
                int x2 = bombs[j][0], y2 = bombs[j][1], r2 = bombs[j][2];

                double c1c2 = Math.hypot(x1-x2, y2-y1);

                if(c1c2 <= r1){
                    adj.get(i).add(j);
                }

                if(c1c2 <= r2){
                    adj.get(j).add(i);
                }
            }
        }

        int maxDetonated = 0;

        // Check each bomb and find the maximum value;
        for(int seed = 0; seed < n; seed++){
            boolean[] isDetonated = new boolean[n];

            maxDetonated = Math.max(maxDetonated, dfs(seed, isDetonated, adj));
        }
        
        return maxDetonated;
    }

    private int dfs(int seed, boolean[] detonated, List<List<Integer>> adj){
        detonated[seed] = true;

        int detonatedBySeed = 1;

        for(int adjBomb : adj.get(seed)){
            if(!detonated[adjBomb]){
                detonatedBySeed += dfs(adjBomb, detonated, adj);
            }
        }

        return detonatedBySeed;
    }
}