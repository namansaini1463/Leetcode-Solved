class Solution {
public:
    vector<vector<int>> findFarmland(vector<vector<int>>& land) {
        vector<vector<int>> result;
        vector<int> landCoordinates;
        int r1 = 0, r2 = 0, c1 = 0, c2 = 0;
        
        int n = land.size();
        int m = land[0].size();

        vector<vector<bool>> visited(n, vector<bool>(m, false));

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(land[i][j] and !visited[i][j]){
                    landCoordinates.push_back(i);
                    landCoordinates.push_back(j);

                    r2 = i, c2 = j;
                    while(r2 < n and land[r2][c2] and !visited[r2][c2]){
                        r2++;
                        visited[r2][c2] = true;
                    } r2--;
                    while(c2 < m and land[r2][c2]){
                        c2++;
                        
                    }c2--;

                    landCoordinates.push_back(r2);
                    landCoordinates.push_back(c2);

                    result.push_back(landCoordinates);
                    landCoordinates.clear();
                }
                
            }
        }

        return result;
    }
};