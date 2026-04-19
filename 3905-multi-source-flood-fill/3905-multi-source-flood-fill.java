class Solution {
    public int[][] colorGrid(int n, int m, int[][] sources) {
        int[][] grid = new int[n][m];
        int[][] dist = new int[n][m];
        for (int[] d : dist)
            Arrays.fill(d, Integer.MAX_VALUE);
        // boolean[][] visited = new boolean[n][m];

        int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        Deque<int[]> q = new ArrayDeque<>();

        for (int[] source : sources) {
            grid[source[0]][source[1]] = source[2];
            // visited[source[0]][source[1]] = true;
            dist[source[0]][source[1]] = 0;

            q.offer(new int[] { source[0], source[1] });
        }

        while (!q.isEmpty()) {

            int[] front = q.poll();
            int row = front[0], col = front[1];

            for (int[] direction : directions) {
                int nr = row + direction[0];
                int nc = col + direction[1];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m)
                    continue;

                int newDistance = dist[row][col] + 1;

                if (newDistance < dist[nr][nc]) {
                    dist[nr][nc] = newDistance;
                    grid[nr][nc] = grid[row][col];

                    q.offer(new int[] { nr, nc });
                } else if (newDistance == dist[nr][nc]) {
                    grid[nr][nc] = Math.max(grid[row][col], grid[nr][nc]);
                }

            }

        }

        // System.out.println(Arrays.deepToString(dist));

        return grid;

    }
}