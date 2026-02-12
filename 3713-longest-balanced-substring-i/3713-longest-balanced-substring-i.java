class Solution {
    private boolean checkAllFreqSame(Map<Character, Integer> freqMap){
        int commonFrequency = -1;
        for(int f : freqMap.values()){
            if(commonFrequency == -1) commonFrequency = f;

            if(f != commonFrequency) return false;
        }
        return true;
    }
    
    public int longestBalanced(String s) {
        int n = s.length();
        int longestBalancedSubstringLength = 0;
   

        for(int i = 0; i < n; i++){
            Map<Character, Integer> freq = new HashMap<>();
            for(int j = i; j < n; j++){
                freq.put(s.charAt(j), freq.getOrDefault(s.charAt(j), 0) + 1);

                boolean allFreqSame = checkAllFreqSame(freq);

                if(allFreqSame){
                    longestBalancedSubstringLength = Math.max(longestBalancedSubstringLength, j - i + 1);
                }
            }
        }

        return longestBalancedSubstringLength;
    }
}