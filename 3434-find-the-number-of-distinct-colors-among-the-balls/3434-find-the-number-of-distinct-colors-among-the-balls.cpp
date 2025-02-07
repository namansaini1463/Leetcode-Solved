class Solution {
public:
    vector<int> queryResults(int limit, vector<vector<int>>& queries) {
        unordered_map<int, int> ballColor; //{ball: color}
        unordered_set<int> colors; //stores the colors in use by the balls

        vector<int> result;

        for(const auto &query : queries){
            int ball = query[0];
            int color = query[1];

            // If the ball-color pair already exists in the map, 
            // then we need to handle the color change of the ball
            if(ballColor.find(ball) != ballColor.end()){
                int oldBallColor = ballColor[ball];
                ballColor[ball] = color;


                //If the color that was used by the ball is not in use by 
                // any other ball, then that color must be removed from the colors set
                int colorPresentInSet = false;
                for(const auto &bc : ballColor){
                    if(bc.second == oldBallColor){
                        colorPresentInSet = true;
                        break;
                    }
                }

                if(!colorPresentInSet){
                    colors.erase(oldBallColor);
                }
            } 

            ballColor[ball] = color;
            colors.insert(color);
        
            result.push_back(colors.size());
        }

        return result;
    }
};