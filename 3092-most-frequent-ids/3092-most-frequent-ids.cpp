class Solution {
public:
    vector<long long> mostFrequentIDs(vector<int>& nums, vector<int>& freq) {
        
        typedef long long ll;

        unordered_map<ll, ll> mp; //{num -> freq}
        vector<ll> result(nums.size());
        priority_queue<pair<ll, ll>>pq; //{freq, num} 

        for(int i = 0; i < nums.size(); i++){
            mp[nums[i]] += freq[i];
            pq.push({mp[nums[i]], nums[i]});

            while(mp[pq.top().second] != pq.top().first) {
                pq.pop();
            }

            result[i] = pq.top().first;
        }
        return result;
    }
        
};