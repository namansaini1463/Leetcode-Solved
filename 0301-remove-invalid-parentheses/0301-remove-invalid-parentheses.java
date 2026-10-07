class Solution {
    Set<String> result = new HashSet<>();
    int bestLength = 0;

    private boolean isValid(String s) {
        int n = s.length();

        // System.out.println("Processing " + s);

        int open = 0, close = 0;
        // L -> R
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(')
                open++;
            else if (s.charAt(i) == ')') {
                if (open > 0)
                    open--;
                else
                    close++;
            }
        }

        return open == 0 && close == 0;
    }

    private void removeInvalidParentheses(int idx, StringBuilder sb, String s) {
        if (idx == s.length()) {
            if (isValid(sb.toString())) {
                bestLength = Math.max(bestLength, sb.length());
                result.add(sb.toString());
            }

            return;
        }

        // System.out.print(idx);
        // if(sb.length() > s.length()) return;
        if (s.charAt(idx) == '(' || s.charAt(idx) == ')') {
            // Skip
            removeInvalidParentheses(idx + 1, sb, s);
        }

        sb.append(s.charAt(idx));
        removeInvalidParentheses(idx + 1, sb, s);
        sb.deleteCharAt(sb.length() - 1);

    }

    public List<String> removeInvalidParentheses(String s) {
        List<String> resultArr = new ArrayList<>();
        
        removeInvalidParentheses(0, new StringBuilder(), s);

        for(String str: result){
            if(str.length() == bestLength) resultArr.add(str);
        }
        System.out.println(result);

        return resultArr;
    }
}