class Solution {
private:
    bool bfs(int row, int col, vector<vector<bool>>& visited, vector<vector<int>>& grid2, vector<vector<int>>& grid1){
        visited[row][col] = true;
        bool isSubIsland = true;
        
        int n = grid2.size();
        int m = grid2[0].size();
        
        int deltaRow[] = {1, 0, -1, 0};
        int deltaCol[] = {0, 1, 0, -1};

        queue<pair<int, int>> q;
        q.push({row, col});

        while(!q.empty()){
            int r = q.front().first;
            int c = q.front().second;
            q.pop();
            
            if(grid1[r][c] == 0){
                isSubIsland = false;
            }

            for(int i = 0; i < 4; i++){
                int nr = r + deltaRow[i];
                int nc = c + deltaCol[i];

                if(nr >= 0 and nr < n and nc >= 0 and nc < m and !visited[nr][nc]
                    and grid2[nr][nc]){
                        visited[nr][nc] = true;
                        q.push({nr, nc});
                    }
            }
        }  

        return isSubIsland;
    }
public:
    int countSubIslands(vector<vector<int>>& grid1, vector<vector<int>>& grid2) {
        int count = 0;

        int n = grid2.size();
        int m = grid2[0].size();

        vector<vector<bool>> visited(n, vector<bool>(m, false));

        for(int i = 0; i < n; i++){
            for(int j = 0 ; j < m; j++){
                if(!visited[i][j] and grid2[i][j]){
                    if(bfs(i, j, visited, grid2, grid1))
                        count++;
                }
            }
        }

        

        return count;
    }
};