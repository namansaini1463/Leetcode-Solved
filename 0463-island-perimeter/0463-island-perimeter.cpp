class Solution {
public:
    int islandPerimeter(vector<vector<int>>& grid) {
        int rows = grid.size();
        int cols = grid[0].size();
        
        int deltaRow[] = {-1, 0, +1, 0};
        int deltaCol[] = {0, +1, 0, -1};
        
        int perimeter = 0;
        
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(grid[r][c]){
                    perimeter += 4;
                    for(int i = 0; i < 4; i++){
                        int nr = r + deltaRow[i];
                        int nc = c + deltaCol[i];
                        
                        if(nr >= 0 and nr < rows and nc >= 0 and nc < cols and grid[nr][nc]){
                            perimeter--;
                        }
                    }
                }
            }
        }
        
        
        
        return perimeter;
    }
};