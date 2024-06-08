class Solution {
public:
    bool checkSubarraySum(vector<int>& nums, int k) {
        if (!k) k = INT_MIN;
		// when k = 0 we want to check the sums are exactly equal
		// we are given that the sum won't exceed INT_MAX
		// so equal modulo INT_MIN = -(INT_MAX+1) implies exactly equal
        unordered_set<int> ns;
        int total = 0;
        for (auto n : nums) {
            auto last = total;
            total += n;
            if (ns.count(total % k)) return true;
            ns.insert(last % k);
        }
        return false;
    }
};