class Solution {
    public String removeOuterParentheses(String s) {
        int n = s.length();

        StringBuilder sb = new StringBuilder();

        int parity = 0;

        for(char ch : s.toCharArray()){
            if(ch =='('){    
            if(parity != 0) sb.append(ch);
                parity++;
            } else {
                parity--;
                if(parity != 0) sb.append(ch);
            }
        }

        return sb.toString();
    }
}