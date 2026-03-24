class Solution {
    private boolean isExitableCell(int r, int c, char[][] maze) {
        int n = maze.length;
        int m = maze[0].length;

        if (r < 0 || r >= n || c < 0 || c >= m) {
            return false;
        }

        return ((r == 0 || r == n - 1) && maze[r][c] == '.') ||
                ((c == 0 || c == m - 1) && maze[r][c] == '.');
    }

    public int nearestExit(char[][] maze, int[] entrance) {
        int n = maze.length;
        int m = maze[0].length;

        int steps = 0;

        int[][] directions = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

        boolean[][] visited = new boolean[n][m];

        Deque<int[]> q = new ArrayDeque<>();
        q.offer(entrance);
        visited[entrance[0]][entrance[1]] = true;

        // if(isExitableCell(entrance[0], entrance[1], maze)) return -1;

        while(!q.isEmpty()){
            int size = q.size();

            // System.out.println("Level :" + steps);

            while(size-- > 0){
                int[] front = q.poll();

                int row = front[0], col = front[1];
                // System.out.println("Processing: " + row + " " + col);

                // the exitable cell should not be the starting cell
                if(!(row == entrance[0] && col == entrance[1]) && isExitableCell(row, col, maze)) return steps;

                for(int[] direction : directions){
                    int nr = row + direction[0];
                    int nc = col + direction[1];

                    if(nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc] && maze[nr][nc] == '.'){
                        q.offer(new int[]{nr, nc});
                        visited[nr][nc] = true;
                    }
                }

            }

            steps++;
        }

        return -1;

    }
}