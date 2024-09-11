class Solution {
public:
    int minBitFlips(int start, int goal) {
        int xored = start ^ goal;
        
        // Count the number of set bits in xored
        int count = 0;
        while (xored) {
            count += xored & 1;
            xored >>= 1; 
        }

        return count;
    }
};
