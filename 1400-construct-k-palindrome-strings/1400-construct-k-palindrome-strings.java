class Solution {
    public boolean canConstruct(String s, int k) {
        // Optimising the code a bit
        if(s.length() < k) return false;
        if(s.length() == k) return true;

        // Creating a frequency array that only stores/tracks the odd chars
        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a'] ^= 1; // Toggle between 0 and 1 for odd/even occurrences
        }
        
        // Count the number of odd chars,
        // If they are less than or equal to 'k', then we can partition the string, otherwise not
        int oddChars = 0;
        for(int i : count){
            oddChars += i;
        }  


        return oddChars <= k ? true : false;
    }
}