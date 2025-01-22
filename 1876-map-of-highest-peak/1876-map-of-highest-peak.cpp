class Solution {
    
public:
    vector<vector<int>> highestPeak(vector<vector<int>>& isWater) {
        int n = isWater.size();
        int m = isWater[0].size();
        
        vector<vector<bool>> visited(n, vector<bool>(m, false));
        vector<vector<int>> result(n, vector<int>(m, 0));

        queue<pair<int, int>> q;

        // Push all the water bodies inititially in the queue
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(isWater[i][j]) {
                    q.push({i, j});
                    visited[i][j] = true;
                    result[i][j] = 0;
                }
            }
        }

        vector<pair<int, int>> directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        int distance = 0;

        while(!q.empty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                auto [x, y] = q.front();
                q.pop();

                for(const auto dir : directions){
                    int newx = x + dir.first;
                    int newy = y + dir.second;

                    if(newx >= 0 and newx < n and newy >= 0 and newy < m and !visited[newx][newy]){
                        visited[newx][newy] = true;
                        q.push({newx, newy});
                        result[newx][newy] = distance + 1;
                    }
                }
            }
            distance++;
        }

        /*
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
               cout << visited[i][j] << " ";
            }
            cout << endl;
        }
        */
   
        return result;
    }
};