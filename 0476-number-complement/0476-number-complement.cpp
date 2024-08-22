class Solution {
public:
    int findComplement(int num) {
        int result = 0;
        int bit_position = 0;
        while (num) {
            bool lsb = num & 1;
            num = num >> 1;
            
            if (!lsb) {
                result = (result << 1) | 1;
            } else {
                result = result << 1;
            }
            
            bit_position++;
        }
        
        return result;
    }
};
