class Solution {
    int n; int m;
    char[][] grid;

    private boolean hasCycle(int i, int j, int pi, int pj, boolean[][] visited){
        if(visited[i][j] == true) return true;

        visited[i][j] = true;

        // System.out.printf("Processing %d - %d ->%c\n", i, j, grid[i][j]);

        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        for(int[] direction : directions){
            int ni = i + direction[0];
            int nj = j + direction[1];

            if(ni == pi && nj == pj) continue;

            if(ni >= 0 && ni < n && nj >= 0 && nj < m && grid[i][j] == grid[ni][nj]){
                if(hasCycle(ni, nj, i, j, visited)) return true;
            }
        }

        return false;

    }

    public boolean containsCycle(char[][] grid) {
        this.grid = grid;
        this.n = grid.length;
        this.m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

      
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!visited[i][j])
                    if(hasCycle(i, j, -1, -1, visited)) return true;
            }
        }

        return false;
    }
}