class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;

        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int maximumGridCostTaken = grid[0][0];

        int[][] time = new int[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(time[i], Integer.MAX_VALUE);
        }
        time[0][0] = grid[0][0]; // Initital time wo hoga joki grid ka starting point ki value hai

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.add(new int[]{grid[0][0], 0, 0}); // {time, row, col}

        while(!pq.isEmpty()){
            int[] top = pq.poll();
            int t = top[0];
            int r = top[1];
            int c = top[2];

            if(t > time[r][c]) continue;

            if(r == n-1 && c == n-1) return t;


            for(int[] direction : directions){
                int nr = r + direction[0];
                int nc = c + direction[1];

                if(nr >= 0 && nr < n && nc >= 0 && nc < n){
                    int newTime = Math.max(t, grid[nr][nc]);

                    if(newTime < time[nr][nc]){
                        time[nr][nc] = newTime;
                        pq.add(new int[]{newTime, nr, nc});
                    }
                }
            }
        }

        // System.out.println(Arrays.deepToString(time));


        return -1;

    }
}