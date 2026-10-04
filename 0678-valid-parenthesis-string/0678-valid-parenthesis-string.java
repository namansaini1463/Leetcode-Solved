class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();

        int open = 0;
        int star = 0;

        // Left -> Right
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                open++;
            } else if (ch == ')') {
                if (open > 0) {
                    open--;
                } else if (star > 0) {
                    star--;
                } else {
                    return false;
                }
            } else {
                star++;
            }
        }

        int close = 0;
        star = 0;

        // Right -> Left
        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            if (ch == ')') {
                close++;
            } else if (ch == '(') {
                if (close > 0) {
                    close--;
                } else if (star > 0) {
                    star--;
                } else {
                    return false;
                }
            } else {
                star++;
            }
        }

        return true;
    }
}