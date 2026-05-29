class Solution {
    int n;
    int m;
    int[][] grid;
    int[][] dp;

    public int f(int i, int j){
        if(i >= n || i < 0 || j >= m || j < 0) return 0;
        if(grid[i][j] == 1) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if(i == n-1 && j == m-1) return 1;

        return dp[i][j] = f(i+1, j) + f(i, j+1);

    }

    public int uniquePathsWithObstacles(int[][] grid) {
        this.n = grid.length;
        this.m = grid[0].length;

        // this.grid = obstacleGrid;
        this.dp = new int[n+1][m+1];

        // Starting cell
        if (grid[0][0] == 1) {
            return 0;
        }

        dp[0][0] = 1;

        // First column
        for (int i = 1; i < n; i++) {
            if (grid[i][0] == 0) {
                dp[i][0] = dp[i - 1][0];
            }
        }

        // First row
        for (int j = 1; j < m; j++) {
            if (grid[0][j] == 0) {
                dp[0][j] = dp[0][j - 1];
            }
        }

        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                if(grid[i][j] == 1) dp[i][j] = 0;
                else dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        // for(int i = 0; i < n; i++){
        //     System.out.println(Arrays.toString(dp[i]));
        // }

        return dp[n-1][m-1];
        // return f(0, 0);
    }
}