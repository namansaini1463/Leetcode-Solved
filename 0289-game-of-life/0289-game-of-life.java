class Solution {
    public void gameOfLife(int[][] board) {
        int n = board.length;
        int m = board[0].length;

        int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1, 0}, {1,1}, {-1, -1}, {1, -1}, {-1, 1}};

        int[][] newBoard = new int[n][m];


        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){

                int alive = 0, dead = 0;
                
                for(int[] direction : directions){
                    int di = i + direction[0];
                    int dj = j + direction[1];

                    if(di >= 0 && di < n && dj >= 0 && dj < m){
                        if(board[di][dj] == 0) dead++;
                        else alive++;
                    }
                }

                if(board[i][j] == 1){
                    if(alive < 2)
                        newBoard[i][j] = 0;
                    else if(alive == 2 || alive == 3) newBoard[i][j] = 1;
                    else newBoard[i][j] = 0;
                } else {
                    if(alive == 3) newBoard[i][j] = 1;
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                board[i][j] = newBoard[i][j];
            }
        }

    }
}