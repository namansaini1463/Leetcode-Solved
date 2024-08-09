class Solution {
private:
    bool isMagicSquare(int row, int col, vector<vector<int>> &grid){
        //checking all the numbers in the range 1-9
        unordered_set<int> allnums;
        for(int r = 0; r < 3; r++){
            for(int c = 0; c < 3; c++){
                if(grid[row + r][col + c] < 10 and grid[row + r][col + c] > 0){
                allnums.insert(grid[row + r][col + c]);
                } 
            }
        }

        if(allnums.size() != 9) return false;
        int row1 = 0, row2 = 0, row3 = 0;
        int col1 = 0, col2 = 0, col3 = 0;
        int d1 = 0, d2 = 0;
        
        row1 = grid[row][col] + grid[row][col + 1] + grid[row][col + 2];
        row2 = grid[row + 1][col] + grid[row + 1][col + 1] + grid[row + 1][col + 2];
        row3 = grid[row + 2][col] + grid[row + 2][col + 1] + grid[row + 2][col + 2];
        col1 = grid[row][col] + grid[row + 1][col] + grid[row + 2][col];
        col2 = grid[row][col + 1] + grid[row + 1][col + 1] + grid[row + 2][col + 1];
        col3 = grid[row][col + 2] + grid[row + 1][col + 2] + grid[row + 2][col + 2];
        d1 = grid[row][col] + grid[row + 1][col + 1] + grid[row + 2][col + 2];
        d2 = grid[row + 2][col] + grid[row + 1][col + 1] + grid[row][col + 2];


        if(row1 == row2 and row1 == row3 and 
           row1 == col1 and row1 == col2 and row1 == col3 and
           row1 == d1 and row2 == d2){
            return true;
        }


        return false;
    } 

public:
    int numMagicSquaresInside(vector<vector<int>>& grid) {
        int rows = grid.size();
        int cols = grid[0].size();

        int magicSqauresCount = 0;

        for(int row = 0; row <= rows - 3; row++){
            for(int col = 0; col <= cols - 3; col++){
                if(isMagicSquare(row, col, grid)) magicSqauresCount++;
            }
        }

        return magicSqauresCount;
    }
};