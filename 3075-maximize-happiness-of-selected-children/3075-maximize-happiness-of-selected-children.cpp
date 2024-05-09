class Solution {
public:
    long long maximumHappinessSum(vector<int>& happiness, int k) {
        /*
        // sort(happiness.begin(), happiness.end(), greater<int>());

        // long long maximumHappiness = 0;

        // int i = 0, j = 0;
        // while(k-- and i != happiness.size()){
        //     cout << happiness[i] << endl;
        //     maximumHappiness = max(maximumHappiness, maximumHappiness + happiness[i]);
        //     i++;
        //     for(j = i; j < happiness.size(); j++){
        //         happiness[j]--;
        //     }
        // }

        // return maximumHappiness;


        */
        int n = happiness.size();
        sort(happiness.begin(), happiness.end(), greater<int>());

        vector<int> newHappiness(n);
        int value = 0;
        for(int i = 0; i < n; i++){
            newHappiness[i] = happiness[i] - i;
        }

        int maxHappiness = 0, i = 0;
        while(k--){
            maxHappiness = max(maxHappiness, maxHappiness + newHappiness[i++]);
        }

        return maxHappiness;
    }
};