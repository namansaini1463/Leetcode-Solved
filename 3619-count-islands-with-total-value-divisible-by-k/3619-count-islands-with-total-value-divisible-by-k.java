class Solution {
    private long dfs(int i, int j, int[][] grid, boolean[][] visited){
        int n = grid.length;
        int m = grid[0].length;

        if(i >= n || i < 0 || j < 0 || j >= m) return 0;
        
        if(grid[i][j] == 0 || visited[i][j]) return 0;

        visited[i][j] = true;

        long islandValue = grid[i][j];
        long right = dfs(i+1, j, grid, visited);
        long top = dfs(i, j-1, grid, visited);
        long left = dfs(i-1, j, grid, visited);
        long bottom = dfs(i, j+1, grid, visited);


        return islandValue + right + left + top + bottom;
    }

    public int countIslands(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        int count = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] != 0 && !visited[i][j]){
                    long islandValue = dfs(i, j, grid, visited);

                    System.out.println(islandValue);

                    if(islandValue % k == 0) count++;
                }
            }
        }

        // System.out.println(Arrays.deepToString(visited));

        return count;
    }
}