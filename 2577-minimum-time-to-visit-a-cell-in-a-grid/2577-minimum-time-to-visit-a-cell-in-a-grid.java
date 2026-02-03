class Solution {
    public int minimumTime(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        int[][] time = new int[n][m];
        for(int[] t : time){
            Arrays.fill(t, Integer.MAX_VALUE);
        }
        time[0][0] = 0;

        if(grid[0][1] > 1 && grid[1][0] > 1) return -1; // It is impossible to oscillate between two cells

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0, 0}); // {time, x, y}

        while(!pq.isEmpty()){
            int[] current = pq.poll();

            int t = current[0], x = current[1], y = current[2];

            if(x == n-1 && y == m-1) return t;

            if(t > time[x][y]) continue;

            for(int[] d : directions){
                int nx = x + d[0];
                int ny = y + d[1];

                if(nx >= 0 && nx < n && ny >= 0 && ny < m){
                    int nt = t + 1; // Time will always increase irrespective of parity of difference
                    if((grid[nx][ny] - t) % 2 == 1){
                        nt = Math.max(nt, grid[nx][ny]);
                    } else {
                        nt = Math.max(nt, grid[nx][ny] + 1);
                    }

                    if(nt < time[nx][ny]){
                        time[nx][ny] = nt;
                        pq.offer(new int[]{nt, nx, ny});
                    }

                    
                }
            }
        }

        return -1;

    }
}