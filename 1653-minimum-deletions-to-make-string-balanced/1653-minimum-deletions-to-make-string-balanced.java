class Solution {
    Integer[][] memo;

    public int minimumDeletions(String s) {
        memo = new Integer[s.length()][2];
        return solve(s, 0, 0); // 0 represents false, 1 represents true
    }

    private int solve(String s, int idx, int state) {
        if (idx == s.length()) return 0;
        
        if (memo[idx][state] != null) return memo[idx][state];

        char c = s.charAt(idx);
        int res;

        // State 1: We are collecting 'b's
        if (state == 1) {
            if (c == 'a') res = 1 + solve(s, idx + 1, 1); // Delete 'a'
            else res = solve(s, idx + 1, 1);              // Keep 'b'
        } 
        // State 0: We are collecting 'a's
        else {
            if (c == 'a') {
                res = solve(s, idx + 1, 0);               // Keep 'a'
            } else {
                // Delete 'b' (stay 0) vs Keep 'b' (switch to 1)
                res = Math.min(1 + solve(s, idx + 1, 0), solve(s, idx + 1, 1));
            }
        }
        
        return memo[idx][state] = res;
    }
}