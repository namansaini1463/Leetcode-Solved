class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{0, 0, 0}); // {absDiffrence, row, col}

        int[][] effort = new int[n][m];
        for(int i = 0; i < n; i++){
            Arrays.fill(effort[i], Integer.MAX_VALUE);
        }
        effort[0][0] = 0;


        int minimumEffort = 0;

        while(!pq.isEmpty()){
            int[] top = pq.poll();
            int currentEffort = top[0];
            int r = top[1];
            int c = top[2];

            if(r == n-1 && c == m-1) return currentEffort;

            for(int[] direction : directions){
                int nr = r + direction[0];
                int nc = c + direction[1];

                if(nr >= 0 && nr < n && nc >= 0 && nc < m){
                    int newEffort = Math.max(currentEffort, Math.abs(heights[r][c] - heights[nr][nc]));

                    if(newEffort < effort[nr][nc]){
                        effort[nr][nc] = newEffort;
                        pq.add(new int[]{newEffort, nr, nc});
                    }
                }
            }
        }

        return -1;

    }
}