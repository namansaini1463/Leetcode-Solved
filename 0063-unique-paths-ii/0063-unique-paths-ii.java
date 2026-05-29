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

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        this.n = obstacleGrid.length;
        this.m = obstacleGrid[0].length;

        this.grid = obstacleGrid;
        this.dp = new int[n+1][m+1];
        
        for(int i = 0; i <= n; i++){
            Arrays.fill(dp[i], -1);
        }

        return f(0, 0);
    }
}