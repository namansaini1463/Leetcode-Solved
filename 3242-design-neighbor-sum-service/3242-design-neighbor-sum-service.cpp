class neighborSum {
private:
    int rows;
    int cols;
    vector<vector<int>> grid;
    unordered_map<int, pair<int, int>> mp; // {number, row, col}
public:
    neighborSum(vector<vector<int>>& grid) {
        this->rows = grid.size();
        this->cols = grid[0].size();

        this->grid = grid;

        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                mp[grid[r][c]] = {r, c};
            }
        }   
    }
    
    int adjacentSum(int value) {
        int sum = 0;
        vector<vector<int>> directions = {{-1, 0}, {0, +1}, {1, 0}, {0, -1}};
        int row = mp[value].first; 
        int col = mp[value].second; 


        for(int i = 0; i < 4; i++){
            int newRow = row + directions[i][0];
            int newCol = col + directions[i][1];

            if(newRow >= 0 and newRow < this->rows and newCol >= 0 and newCol < this->cols){
                sum += this->grid[newRow][newCol];
            }
        }

        return sum;
    }
    
    int diagonalSum(int value) {
        int sum = 0;
        vector<vector<int>> directions = {{-1, -1}, {+1, +1}, {-1, +1}, {+1, -1}};
        int row = mp[value].first; 
        int col = mp[value].second; 

        for(int i = 0; i < 4; i++){
            int newRow = row + directions[i][0];
            int newCol = col + directions[i][1];

            if(newRow >= 0 and newRow < rows and newCol >= 0 and newCol < cols){
                sum += this->grid[newRow][newCol];
            }
        }

        return sum;
    }
};

/**
 * Your neighborSum object will be instantiated and called as such:
 * neighborSum* obj = new neighborSum(grid);
 * int param_1 = obj->adjacentSum(value);
 * int param_2 = obj->diagonalSum(value);
 */