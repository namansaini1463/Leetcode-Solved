class Solution {
private:
    bool checkPathWithDistanceMid(vector<vector<int>>& distanceGrid, int safeDistance){
        /*
            Checking a valid from (0,0) to (n - 1, m - 1)
        */
        
        int n = distanceGrid.size();
        int m = distanceGrid[0].size();

        queue<pair<int, int>> q;
        vector<vector<bool>> visited(n, vector<bool>(m, false));

        if(distanceGrid[0][0] >= safeDistance){
            q.push({0, 0});
            visited[0][0] = true;
        }

        int deltaRow[] = {-1, 0, +1, 0};
        int deltaCol[] = {0, +1, 0, -1};

        while(!q.empty()){
            int row = q.front().first;
            int col = q.front().second;
            q.pop();

            if(row == n - 1 and col == m - 1) return true;

            for(int i = 0; i < 4; i++){
                int newRow = row + deltaRow[i];
                int newCol = col + deltaCol[i];

                if(newRow >= 0 and newRow < n and newCol >= 0 and newCol < m and !visited[newRow][newCol] ){
                    if(distanceGrid[newRow][newCol] >= safeDistance){
                        q.push({newRow, newCol});
                        visited[newRow][newCol] = true;
                    }
                }
            }
        }

        return false;
    }

public:
    int maximumSafenessFactor(vector<vector<int>>& grid) {
        int n = grid.size();
        int m = grid[0].size();
        
        if(grid[0][0]) return 0;

        vector<vector<int>> minimumDistanceFromTheif(n, vector<int>(m, -1));
        vector<vector<bool>> visited(n, vector<bool>(m, false));

        queue<pair<int, int>> q;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j]){
                    q.push({i, j});
                    minimumDistanceFromTheif[i][j] = 0;
                    // visited[i][j] = true;
                }
            }
        }

        int minimumSafeDistance = 1;
        int deltaRow[] = {-1, 0, +1, 0};
        int deltaCol[] = {0, +1, 0, -1};

        while(!q.empty()){
            int size = q.size();

            while(size--){
                int row = q.front().first;
                int col = q.front().second;
                q.pop();

                for(int i = 0; i < 4; i++){
                    int newRow = row + deltaRow[i];
                    int newCol = col + deltaCol[i];

                    if(newRow >= 0 and newRow < n and newCol >= 0 and newCol < m and minimumDistanceFromTheif[newRow][newCol] == -1){
                        minimumDistanceFromTheif[newRow][newCol] = minimumSafeDistance;
                        q.push({newRow, newCol});
                        // visited[newRow][newCol] = true;
                    }
                }
            }
            minimumSafeDistance++;
        }

        int minSafestDistance = 1, l = minSafestDistance;
        int maxSafestDistance = n + m - 2, r = maxSafestDistance;
        int result = 0;

        while( l <= r ){
            int mid = l + (r - l) / 2;

            if(checkPathWithDistanceMid(minimumDistanceFromTheif, mid)){
                result = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
               cout << minimumDistanceFromTheif[i][j] << " ";
            } cout << endl;
        }

        return result;
    }
};