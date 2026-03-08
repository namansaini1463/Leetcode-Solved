class Solution {
    private boolean check(StringBuilder s, Set<String> stringSet, int n){
        if(s.length() > n) return false;

        if(s.length() == n){
            if(!stringSet.contains(s.toString())) return true;
        }
        
        s.append("0");
        if(check(s, stringSet, n)) return true;
        s.deleteCharAt(s.length() - 1);

        s.append("1");
        if(check(s, stringSet, n)) return true;
        s.deleteCharAt(s.length() - 1);

        
        return false;
    }

    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;

        // Create a set with all the array strings in it
        Set<String> stringSet = new HashSet<>();
        for(String s : nums){
            stringSet.add(s);
        }

        StringBuilder differentBinaryString = new StringBuilder();

        differentBinaryString.append("0");
        if(check(differentBinaryString, stringSet, n)) return differentBinaryString.toString();
        differentBinaryString.deleteCharAt(differentBinaryString.length() - 1);

        differentBinaryString.append("1");
        if(check(differentBinaryString, stringSet, n)) return differentBinaryString.toString();
        differentBinaryString.deleteCharAt(differentBinaryString.length() - 1);

        return differentBinaryString.toString();

    }
}