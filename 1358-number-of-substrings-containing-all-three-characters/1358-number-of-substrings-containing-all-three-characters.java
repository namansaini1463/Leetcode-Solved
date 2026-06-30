class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        Map<Character, Integer> freq = new HashMap<>();

        int i = 0, j = 0;

        int result = 0;

        while(j < n){
            char ch = s.charAt(j);
            j++;
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);


            while(freq.size() == 3 && i < j){
                result += (n - j + 1);

                if(freq.get(s.charAt(i)) == 1){
                    freq.remove(s.charAt(i));
                } else {
                    freq.put(s.charAt(i), freq.get(s.charAt(i)) - 1);
                }

                i++;
            }
            
            // System.out.println(freq);
        }

        return result;
        

    }
}