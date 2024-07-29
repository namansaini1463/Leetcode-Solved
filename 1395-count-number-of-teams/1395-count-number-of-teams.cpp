class Solution {
public:
    int numTeams(vector<int>& rating) {
        /*
        int n = rating.size();
        int teamsCount = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                for(int k = j+1; k < n; k++){
                    if(rating[i] < rating[j] and rating[j] < rating[k]) teamsCount++;
                    if(rating[i] > rating[j] and rating[j] > rating[k]) teamsCount++;

                }
            }
        }

        return teamsCount;
        */

        int n = rating.size();
        int teamsCount = 0;

        for(int j = 1; j < n-1; j++){
            int smallerLeft = 0;
            int largerRight = 0;
            int smallerRight = 0;
            int largerLeft = 0;

            for(int i = 0; i < j; i++){
                if(rating[i] < rating[j]){
                    smallerLeft++;
                } else {
                    largerLeft++;
                }
            }

            for(int k = j+1; k < n; k++){
                if(rating[j] < rating[k]){
                    largerRight++;
                } else {
                    smallerRight++;
                }
            } 

            teamsCount += smallerLeft*largerRight + largerLeft*smallerRight;
        }

        return teamsCount;
    }
};