class Solution {
public:
    vector<int> sequentialDigits(int low, int high) {
        vector<int> result;
        
        int maxLength = 9; // 12345679
        // Starting with the smallest possible number with sequential digits -> 12
        for (int length = 2; length <= 9; length++) { // Maximum length of sequential digits is 9 (123456789)
            for (int startingDigit = 1; startingDigit <= maxLength - length + 1; startingDigit++) {
                int num = 0;
                for (int j = startingDigit; j < startingDigit + length; j++) { // Build the number
                    num = num * 10 + j;
                }
                if (num >= low and num <= high) { // Check if the number is within the range
                    result.push_back(num);
                }
                if (num > high) return result; // Agar num high se zyada hai to return krado
            }
        }
        
        return result;
    }
};