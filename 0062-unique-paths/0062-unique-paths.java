class Solution {
    int m; 
    int n;

    int[][] dp;

    // public int f(int i, int j){
    //     if (i < 0 || j < 0 || i >= m || j >= n) return 0;

    //     if(i == m-1 && j == n-1) return 1;

    //     if(dp[i][j] != -1) return dp[i][j];

    //     return dp[i][j] = f(i+1, j) + f(i, j+1);
    // }

    public int uniquePaths(int m, int n) {
        this.m = m;
        this.n = n;

        this.dp = new int[m+1][n+1];

        for(int i = 0; i <= m; i++){
            dp[i][0] = 1;
        }

        for(int j = 0; j <= n; j++){
            dp[0][j] = 1;
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        // System.out.println(Arrays.deepToString(dp));

        return dp[m-1][n-1];
    }
}