class Solution {
    int[][] palindrome;

    public int isPalindrome(String s, int start, int end) {
        if (palindrome[start][end] != -1) return palindrome[start][end];

        int origStart = start;
        int origEnd = end;

        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return palindrome[origStart][origEnd] = 0;
            }
        }

        return palindrome[origStart][origEnd] = 1;
    }

    public int countSubstrings(String s) {
        int n = s.length();
        if (n == 1) return 1;

        palindrome = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(palindrome[i], -1);
        }

        int count = 0;
        // Check ALL possible start and end combinations
        for (int start = 0; start < n; start++) {
            for (int end = start; end < n; end++) {
                if (isPalindrome(s, start, end) == 1) {
                    count++;
                }
            }
        }

        return count;
    }
}