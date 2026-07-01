class Solution {
    private boolean isVowel(char ch){
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
    public long countOfSubstrings(String s, int k) {
        int n = s.length();
        long count = 0;

        Map<Character, Integer> vowels = new HashMap<>();
        int consonantCount = 0;

        int[] nextConsonant = new int[n];
        int lastConsonantIndex = n;
        nextConsonant[n-1] = lastConsonantIndex;
        for(int i = n-1; i >= 0; i--){
            nextConsonant[i] = lastConsonantIndex;
            if(!isVowel(s.charAt(i))) lastConsonantIndex = i;

        }

        // System.out.println(Arrays.toString(nextConsonant));
        int i = 0, j = 0;
        while(j < n){
            char ch = s.charAt(j);

            if(isVowel(ch)){
                vowels.put(ch, vowels.getOrDefault(ch, 0) + 1);
            } else {
                consonantCount++;
            }

            while(consonantCount > k){
                if(isVowel(s.charAt(i))){
                    vowels.put(s.charAt(i), vowels.get(s.charAt(i)) - 1);

                    if(vowels.get(s.charAt(i)) == 0) vowels.remove(s.charAt(i));
                } else {
                    consonantCount--;
                }
                i++;
            }

            while(vowels.size() == 5 && consonantCount == k){
                count += nextConsonant[j] - j;

                if(isVowel(s.charAt(i))){
                    vowels.put(s.charAt(i), vowels.get(s.charAt(i)) - 1);

                    if(vowels.get(s.charAt(i)) == 0) vowels.remove(s.charAt(i));
                } else {
                    consonantCount--;
                }
                i++;
            }

            j++;

        }

        return count;
    }
}