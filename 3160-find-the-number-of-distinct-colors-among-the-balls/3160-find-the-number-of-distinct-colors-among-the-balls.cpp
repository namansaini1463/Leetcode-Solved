class Solution {
public:
    vector<int> queryResults(int limit, vector<vector<int>>& queries) {
        unordered_map<int, int> ballColor; //{ball: color}
        unordered_set<int> colors; //stores the colors in use by the balls

        vector<int> result;

        for(const auto &query : queries){
            int ball = query[0];
            int color = query[1];

            if(ballColor.find(ball) != ballColor.end()){
                int oldBallColor = ballColor[ball];
                ballColor[ball] = color;

                int colorInSet = false;
                for(const auto &bc : ballColor){
                    if(bc.second == oldBallColor){
                        colorInSet = true;
                        break;
                    }
                }

                if(!colorInSet){
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