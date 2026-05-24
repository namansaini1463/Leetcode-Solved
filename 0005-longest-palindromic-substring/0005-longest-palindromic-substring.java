class Solution {
    int[][] palindrome;
    private int isPalindrome(String s, int i, int j){
        if(palindrome[i][j] != -1) return palindrome[i][j];

        if(i >= j) return palindrome[i][j] = 1;
        if(s.charAt(i) != s.charAt(j)) return palindrome[i][j] = 0;

        return palindrome[i][j] = isPalindrome(s, i+1, j-1);
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        this.palindrome = new int[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(palindrome[i], -1);
        }

        String longestPalindromicSubstring = "";

        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                if(isPalindrome(s, i, j) == 1){
                    if(j - i + 1 > longestPalindromicSubstring.length()){
                        longestPalindromicSubstring = s.substring(i, j+1);
                    }
                }
            }
        }

        return longestPalindromicSubstring;
    }
}