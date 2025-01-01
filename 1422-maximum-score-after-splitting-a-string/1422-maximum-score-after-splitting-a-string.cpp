class Solution {
public:
    int maxScore(string s) {
        int onesCount = 0;
        int zerosCount = 0;

        // Precomputing the number of ones in the string
        for(int i = 0; i < s.size(); i++){
            if(s[i] == '1') onesCount++;
        }

        // Variable to store the maximum score of the string
        int maxScore = INT_MIN;

        // i marks as the splitter for the two substrings
        // s.size() - 1 becoz, the strings are non empty
        for(int i = 0; i < s.size() - 1; i++){
            // current score = zerosCount + onesCount
            if(s[i] == '0'){
                // increase the zero count and calculate current score then update maxScore
                maxScore = max(maxScore, ++zerosCount + onesCount);
            } else {
                // decrease the one count and calculate current score then update maxScore
                maxScore = max(maxScore, zerosCount + --onesCount);
            }
        }

        return maxScore;
    }
};