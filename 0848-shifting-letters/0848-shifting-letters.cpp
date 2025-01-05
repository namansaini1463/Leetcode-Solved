class Solution {
public:
    string shiftingLetters(string s, vector<int>& shifts) {
        int n = shifts.size();

        vector<int> prefixReverseSum(n, 0);
        prefixReverseSum[n-1] = shifts[n-1];

        for(int i = shifts.size() - 2; i >= 0; --i){
            prefixReverseSum[i] = (prefixReverseSum[i+1] + shifts[i]) % 26;
        }
        
        for(int i = 0; i < n; i++){
            s[i] = 'a' + (s[i] - 'a' + prefixReverseSum[i]) % 26;
        }

        return s;
    }
};