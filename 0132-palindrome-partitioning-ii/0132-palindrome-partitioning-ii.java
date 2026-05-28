class Solution {
    int n;
    boolean[][] isPalindrome;
    int[] dp;

    public int f(int idx){
        if(idx == n) return -1;

        if(dp[idx] != -1) return dp[idx];

        int cuts = n-1;

        for(int j = idx; j < n; j++){
            if(isPalindrome[idx][j]){
                cuts = Math.min(cuts, 1 + f(j+1));
            }
        }
        

        return dp[idx] = cuts;
    }

    public int minCut(String s) {
        this.n = s.length();

        this.isPalindrome = new boolean[n][n];

        this.dp = new int[n+1];
        Arrays.fill(dp, -1);

        for(int i = 0; i < n; i++){
            isPalindrome[i][i] = true;
        }

        for(int l = 2; l <= n; l++){
            for(int i = 0; i + l - 1 < n; i++){
                int j = i + l - 1;

                if(s.charAt(i) == s.charAt(j)){
                    if(l == 2) isPalindrome[i][j] = true;
                    else isPalindrome[i][j] = isPalindrome[i+1][j-1];
                }
            } 
        }

        for(int idx = n-1; idx >= 0; idx--){
            int cuts = n-1;
            
            for(int j = idx; j < n; j++){
                if(isPalindrome[idx][j]){
                    cuts = Math.min(cuts, 1 + dp[j+1]);
                }
            }

            dp[idx] = cuts;
        }

        return dp[0];
    }
}