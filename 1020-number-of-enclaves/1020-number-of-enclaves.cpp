class Solution {
public:
    int numEnclaves(vector<vector<int>>& grid) {
        int n = grid.size(), m = grid[0].size();
        vector<vector<bool>> visited(n, vector<bool>(m, false));

        stack<pair<int, int>> st;

        // identifying the 1s that are on the boundary of the grid
        for(int i = 0; i < n; i++){
            // checking for the left boundary
            if(grid[i][0]) st.push({i, 0});
            // checking for the right boundary
            if(grid[i][m-1]) st.push({i, m-1});
        }

        for(int i = 0; i < m; i++){
            // checking for the top boundary
            if(grid[0][i]) st.push({0, i});
            // checking for the bottom boundary
            if(grid[n-1][i]) st.push({n-1, i});
        }

        int deltaRow[] = {-1, 0, 1, 0};
        int deltaCol[] = {0, 1, 0, -1};

        while(!st.empty()){
            int row = st.top().first;
            int col = st.top().second;
            st.pop();

            if(!visited[row][col]){
                visited[row][col] = true;

                for(int i = 0; i < 4; i++){
                    int nrow = row + deltaRow[i];
                    int ncol = col + deltaCol[i];

                    if((nrow >= 0 and nrow < n) and (ncol >= 0 and ncol < m) and (grid[nrow][ncol]) and (!visited[nrow][ncol])){
                        st.push({nrow, ncol});
                    }
                }
            }
        }

        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!visited[i][j] and grid[i][j]) count++;
            } 
        }

        return count;
    }
};