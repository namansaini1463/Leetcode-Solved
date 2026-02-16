class Solution {
    public int reverseBits(int n) {
        int result = 0;
        for(int i = 0; i < 32; i++){
            int bit = n&1; // Get last bit
            n = n >> 1;  // Move the number right by 1 bit

            result = result | bit << (31 - i); 
        }

        return result;
    }
}