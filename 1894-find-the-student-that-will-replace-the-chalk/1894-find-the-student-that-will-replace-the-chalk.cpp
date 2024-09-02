class Solution {
public:
    int chalkReplacer(vector<int>& chalk, int k) {
        long long totalSum = 0;
        for(const auto &c : chalk){
            totalSum += c;
        }

        int remaining = k % totalSum;

        for(int i = 0; i < chalk.size(); i++){
            remaining -= chalk[i];

            if(remaining < 0) return i;
        }

        return -1;
    }
};