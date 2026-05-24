class Solution {
    public int countSubstrings(String s) {
        int n = s.length();

        boolean[][] palindrome = new boolean[n][n];

        int count = 0;

        for(int L = 1; L <= n; L++){
            for(int i = 0; i + L - 1 < n; i++){
                int j = i + L - 1;

                if(i == j) {
                    palindrome[i][i] = true;
                } else if(j == i + 1){
                    palindrome[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    palindrome[i][j] = s.charAt(i) == s.charAt(j) &&  palindrome[i+1][j-1];
                }

                if(palindrome[i][j]) count++;
            }
        }

        return count;


    }
}