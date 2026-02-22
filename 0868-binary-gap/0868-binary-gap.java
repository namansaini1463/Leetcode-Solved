class Solution {
    public int binaryGap(int n) {
        String binaryString = Integer.toBinaryString(n);

        int i = 0, j = 0;
        int gap = 0;
        for(; j < binaryString.length(); j++){
            if(binaryString.charAt(j) == '1'){
                gap = Math.max(gap, j - i);
                i = j;
            } 
        }

       return gap;
    }
}