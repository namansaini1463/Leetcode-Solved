class Solution {
    int[][] dp;
    public int LPS(String s, int i, int j){
        if(i > j) return 0;
        if(i == j) return 1;

        if(dp[i][j] != -1) return dp[i][j];

        if(s.charAt(i) == s.charAt(j)){
            return dp[i][j] = 2 + LPS(s, i+1, j-1);
        } 

        return dp[i][j] = Math.max(LPS(s, i+1, j), LPS(s, i, j-1));
    }
    public int longestPalindromeSubseq(String s) {
        int n = s.length();

        this.dp = new int[n+1][n+1];
        for(int i = 0; i <= n; i++){
            Arrays.fill(dp[i], -1);
        }

        return LPS(s, 0, n-1);
    }
}