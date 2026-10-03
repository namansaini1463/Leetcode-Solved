class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();

        int maxLength = 0;

        int open = 0, close = 0;

        // Left to Right
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '(') open++;
            else close++;

            if(close > open){
                open = 0; close = 0;
            }

            if(open == close) maxLength = Math.max(maxLength, open + close);
        }
        
        open = 0; close = 0;

        // Right to left
        for(int i = n-1; i >=0; i--){
            if(s.charAt(i) == '(') open++;
            else close++;

            if(open > close){
                open = 0; close = 0;
            }

            if(open == close) maxLength = Math.max(maxLength, open + close);
        }

        return maxLength;
    }
}