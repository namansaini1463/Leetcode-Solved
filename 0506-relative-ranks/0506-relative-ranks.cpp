class Solution {
public:
    vector<string> findRelativeRanks(vector<int>& score) {
        int n = score.size();
        vector<string> result(n);
        
        priority_queue<pair<int, int>> pq;
        
        for(int i = 0; i < n; i++){
            pq.push({score[i], i});
        }
        
        int position = 1;
        while(!pq.empty()){
            auto p = pq.top(); pq.pop();
            
            if(position == 1) {
                result[p.second] = "Gold Medal";
                position++;
            } else if(position == 2){
                result[p.second] = "Silver Medal";
                position++;
            } else if(position == 3){
                result[p.second] = "Bronze Medal";
                position++;
            } else {
                result[p.second] = to_string(position);
                position++;
            }
            
        }
        
        return result;
    }
};