class Solution {
    public int numberOfSpecialChars(String word) {
        boolean[] lowerCase = new boolean[26];
        boolean[] upperCase = new boolean[26];

        for(char ch : word.toCharArray()){
            if(ch >= 'a' && ch <= 'z') lowerCase[(int)(ch - 'a')] = true;
            else upperCase[(int)(ch - 'A')] = true;
        }

        int count = 0;
        for(int i = 0; i < 26; i++){
            if(lowerCase[i] && upperCase[i]) count++;
        }

        return count;
    }
}