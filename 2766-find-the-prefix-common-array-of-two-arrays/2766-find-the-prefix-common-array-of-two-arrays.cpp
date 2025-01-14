class Solution {
public:
    vector<int> findThePrefixCommonArray(vector<int>& A, vector<int>& B) {
        int n = A.size();
        vector<int> count(n+1, 0);

        vector<int> result(n);

        for(int i = 0; i < n; i++){
            count[A[i]]++;
            count[B[i]]++;

            int resultCount = 0;
            for(const auto &c : count){
                if(c == 2) resultCount++;
            }
            result[i] = resultCount;
        }

        return result;
    }  
};