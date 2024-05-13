class Solution {
public:
    int matrixScore(vector<vector<int>>& grid) {
        int rows = grid.size();
        int cols = grid[0].size();
        
        // Checking the first column and changing all its bits to 1 by flipping the entire row
        for(int row = 0; row < rows; row++){
            cout << grid[row][0] << endl;
            if(grid[row][0] == 0){
                for(int col = 0; col < cols; col++){
                    grid[row][col] = !grid[row][col];
                }
            }
        }
        
        for(auto i : grid){
            for(auto j : i) cout << j <<" ";
            cout << endl;
        }
        
        // Checking the remaining columns and if the number of zeros in that column are more than the number of ones, then flip the entire column
        for(int col = 1; col < cols; col++){
            int rowZeroCount = 0;
            for(int row = 0; row < rows; row++){
                if(!grid[row][col]) rowZeroCount++; 
            }

            if(rowZeroCount > cols/2){
                for(int row = 0; row < rows; row++){
                    grid[row][col] = !grid[row][col];
                }
            }
        }

        

        return -1;
    }
};