class Solution {
public:
    vector<int> frequencySort(vector<int>& nums) {
        unordered_map<int, int> freqMap;

        // Step 1: Count the frequency of each element
        for (int num : nums) {
            freqMap[num]++;
        }

        // Step 2: Define a custom comparator function
        auto comparator = [&](int a, int b) {
            if (freqMap[a] == freqMap[b]) {
                return a > b; // If frequencies are equal, sort in decreasing order
            }
            return freqMap[a] < freqMap[b]; // Otherwise, sort based on frequency in increasing order
        };

        // Step 3: Sort the elements based on the custom comparator
        sort(nums.begin(), nums.end(), comparator);

        // Step 4: Return the sorted array
        return nums;
    }
};