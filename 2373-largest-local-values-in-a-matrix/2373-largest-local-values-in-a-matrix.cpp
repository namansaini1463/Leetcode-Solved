class Solution {
public:
    int findLocalMax(int row, int col, vector<vector<int>> &grid){
        int localMax = INT_MIN;
        for(int i = row-1; i <= row+1; i++){
            for(int j = col-1; j <= col+1; j++){
                localMax = max(localMax, grid[i][j]);
            }
        }

        return localMax;
    }
    vector<vector<int>> largestLocal(vector<vector<int>>& grid) {
        int n = grid.size();
        
        vector<vector<int>> result(n-2, vector<int>(n-2, 0));

        for(int row = 1; row < n-1; row++){
            for(int col = 1; col < n-1; col++){
                result[row-1][col-1] = findLocalMax(row, col, grid);

            }
        }
        
        return result;
    }
};