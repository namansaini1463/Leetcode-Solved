class Solution {
public:
    int maxSubarrayLength(vector<int>& nums, int k) {
        /*
            Using two pointers sliding window 
            and two while loops
        */
        /*
        unordered_map<int, int> freq;
        int i = 0, j = 0;

        int length = 0;

        while(j != nums.size()){
            freq[nums[j]]++;

            while(i < j and freq[nums[j]] > k){
                freq[nums[i]]--;
                i++;
            }

            length = max(length, j - i + 1);
            j++;
        }

        return length;
        */

        /*
            Using two points and a single while loop
        */

        unordered_map<int, int> freq;
        int  i = 0, j = 0;
        int length = 0;
        int culprit = 0;

        while( j != nums.size()){
            freq[nums[j]]++;

            if(freq[nums[j]] > k){
                culprit++;
            }

            if(culprit){
                freq[nums[i]]--;
                
                if(freq[nums[i]] == k){
                    culprit--;
                }
                i++;
            } else {
                length = max(length, j - i + 1);
            }

            j++;
        }

        return length;

    }
};