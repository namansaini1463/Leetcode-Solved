class Solution {
public:
    int maxScore(string s) {
        int onesCount = 0;
        int zerosCount = 0;
        for(int i = 0; i < s.size(); i++){
            if(s[i] == '1') onesCount++;
        }

        int maxScore = INT_MIN;

        for(int i = 0; i < s.size() - 1; i++){
            if(s[i] == '0'){
                maxScore = max(maxScore, ++zerosCount + onesCount);
            } else {
                maxScore = max(maxScore, zerosCount + --onesCount);
            }
        }

        return maxScore;
    }
};