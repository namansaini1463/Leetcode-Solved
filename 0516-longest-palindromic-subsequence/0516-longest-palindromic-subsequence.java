class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();

        int[][] LPS = new int[n+1][n+1];

        for(int i = 0; i <= n; i++){
            LPS[i][i] = 1;
        }

        for(int L = 2; L <= n; L++){
            for(int i = 0; i + L - 1 < n; i++){
                int j = i + L - 1;

                if(s.charAt(i) == s.charAt(j)){
                    LPS[i][j] = 2 + LPS[i+1][j-1];
                } else {
                    LPS[i][j] = Math.max(LPS[i+1][j], LPS[i][j-1]);
                }
            }
        }

        return LPS[0][n-1];
    }
}