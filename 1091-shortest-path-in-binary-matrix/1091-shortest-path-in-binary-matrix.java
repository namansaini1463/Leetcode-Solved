class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] directions = {{0,1}, {0,-1}, {1, 0}, {-1, 0}, {1, 1}, {-1, 1}, {1, -1}, {-1, -1}};

        if(grid[0][0] == 1) return -1;

        boolean[][] visited = new boolean[n][m];

        Deque<int[]> q = new ArrayDeque<>(); 
        visited[0][0] = true;
        q.offer(new int[]{0, 0});

        int steps = 1;

        while(!q.isEmpty()){
            int size = q.size();

            while(size-- > 0){
                int[] front = q.pop();

                int r = front[0], c = front[1];

                if(r == n-1 && c == m-1) return steps;

                for(int[] direction : directions){
                    int nr = r + direction[0];
                    int nc = c + direction[1];

                    if(nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc] && grid[nr][nc] == 0){
                        visited[nr][nc] = true;
                        q.offer(new int[]{nr, nc});
                    }
                }
            }

            steps++;
        }

        return -1;
    }
}