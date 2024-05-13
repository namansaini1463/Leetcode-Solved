class Solution {
public:
    int matrixScore(vector<vector<int>>& grid) {
        int rows = grid.size();
        int cols = grid[0].size();
        
        // Checking the first column and changing all its bits to 1 by flipping the entire row
        for(int row = 0; row < rows; row++){
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
        cout << endl;
        
        // Checking the remaining columns and if the number of zeros in that column are more than the number of ones, then flip the entire column
        for(int col = 1; col < cols; col++){
            int colZeroCount = 0;
            for(int row = 0; row < rows; row++){
                if(!grid[row][col]) colZeroCount++; 
            }

            if(colZeroCount * 2 > rows){
                for(int row = 0; row < rows; row++){
                    grid[row][col] = !grid[row][col];
                }
            }
        }

        int maxScore = 0;
        // Finding the result by converting each row of the matrix into equivalent decimal numers
        for(int row = 0; row < rows; row++){
            int number = 0;
            for(int col = 0; col < cols; col++){
                number = number * 2 + grid[row][col];
            }
            maxScore += number;
        }

        for(auto i : grid){
            for(auto j : i) cout << j <<" ";
            cout << endl;
        }

        return maxScore;
    }
};