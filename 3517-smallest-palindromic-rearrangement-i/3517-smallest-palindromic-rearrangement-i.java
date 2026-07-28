class Solution {
    public String smallestPalindrome(String s) {
        char oddCharacter = ' ';

        int[] frequency = new int[26];
        for(char ch : s.toCharArray()){
            frequency[ch - 'a']++;
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 26; i++){
            if(frequency[i] > 0){
                int f = frequency[i];

                if(f % 2 == 1 && oddCharacter == ' ') oddCharacter = (char)('a' + i);

                f = f / 2;
                while(f-- > 0) sb.append((char)('a' + i));
            }
        }

        StringBuilder result = new StringBuilder();
        if(oddCharacter != ' '){
            result.append(sb.toString()).append(oddCharacter).append(sb.reverse());
        } else {
            result.append(sb.toString()).append(sb.reverse());
        }

        return result.toString();
    }
}