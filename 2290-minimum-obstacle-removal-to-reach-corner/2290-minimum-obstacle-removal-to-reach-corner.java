class Solution {
    public int minimumObstacles(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        int[][] distance = new int[n][m];
        for(int[] d : distance) Arrays.fill(d, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{0, 0, 0}); // {distance, row, col}

        while(!pq.isEmpty()){
            int[] top = pq.poll();
            int d = top[0];
            int r = top[1];
            int c = top[2];

            if(d > distance[r][c]) continue;

            if(r == n-1 && c == m-1) return d;

            for(int[] direction : directions){
                int nr = r + direction[0];
                int nc = c + direction[1];

                if(nr >= 0 && nr < n && nc >= 0 && nc < m){
                    if(d + grid[nr][nc] < distance[nr][nc]){
                        distance[nr][nc] = d + grid[nr][nc];
                        pq.add(new int[]{d + grid[nr][nc], nr, nc});
                    }
                }
            }
        }


        return -1;

    }
}