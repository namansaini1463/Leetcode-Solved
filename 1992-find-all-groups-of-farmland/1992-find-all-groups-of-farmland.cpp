class Solution {
private:
    void findFarmland(int row, int col, vector<vector<bool>>& visited, vector<vector<int>>& land, vector<vector<int>>& result, int &r2, int &c2){
        visited[row][col] = true;
        r2 = max(r2, row);
        c2 = max(c2, col);

        int n = land.size();
        int m = land[0].size();

        int deltaRow[] = {-1, 0, 1, 0};
        int deltaCol[] = {0, 1, 0, -1};

        for(int i = 0; i < 4; i++){
            int nr = row + deltaRow[i];
            int nc = col + deltaCol[i];

            if(nr >= 0 and nr < n and nc >= 0 and nc < m and land[nr][nc] and !visited[nr][nc]){
                findFarmland(nr, nc, visited, land, result, r2, c2);
            }
        }
    }

public:
    vector<vector<int>> findFarmland(vector<vector<int>>& land) {
        vector<vector<int>> result;

        int n = land.size();
        int m = land[0].size();
        vector<vector<bool>> visited(n, vector<bool>(m, false));

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(land[i][j] and !visited[i][j]){
                    int r1 = i, c1 = j, r2 = i, c2 = j; // Initialize bounding box coordinates
                    findFarmland(i, j, visited, land, result, r2, c2);
                    result.push_back({r1, c1, r2, c2}); // Push the bounding box coordinates to the result
                }
            }
        }

        return result;
    }
};