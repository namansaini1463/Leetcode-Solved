class Solution {
public:
    int minSwaps(vector<int>& nums) {
        int n = nums.size();
        int totalOnes = 0;
        for(const auto &num : nums){
            if(num) totalOnes++;
        }

        if (totalOnes == 0 or totalOnes == n) return 0; // No swaps needed if there are no 1s or all are 1s

        int currentOnes = 0, maxOnes = 0;

        int i = 0, j = 0;
        while( j < 2 * n){
            if(nums[j%n] == 1) currentOnes++;

            if(j - i + 1 > totalOnes){
                currentOnes -= nums[i%n];
                i++;
            }

            maxOnes = max(maxOnes, currentOnes);
            j++;
        }

        return totalOnes - maxOnes;
    }

};