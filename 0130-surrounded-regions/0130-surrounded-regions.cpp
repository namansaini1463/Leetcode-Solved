class Solution {
public:
    /*
        - Only those zeros will be unaffected jo ki boundary pr honge
        - Ya fir wo wale zeros, joki boundary wale zeros se direct ya indirect contact mei honge
        - To sabse pehle hum boundary wale zeros ko identify krlenge and then unnhe ek stack mei daal denge
        - Usse baad hum DFS lga kr wo saare zeros identify kr lenge joki uss zero se connected hain and unnka track rakhenge ek visited board se
        - Saare zeros ko process krne ke baad hum wo visited board check karenge and ussmei jo jo zeros visit nhi hue honge unn sabko 'X' bna denge
    */
    void solve(vector<vector<char>>& board) {
        int n = board.size(), m = board[0].size();
        stack<pair<int, int>> st;
        vector<vector<bool>> visited(n, vector<bool>(m, false));

        // Checking the left and the right columns for the boundary Os
        for(int r = 0; r < n; r++){
            if(board[r][0] == 'O') st.push({r, 0});
            if(board[r][m-1] == 'O') st.push({r, m-1});
        }
        // Checking the top and the bottom rows for the boundary Os
        for(int c = 0; c < m; c++){
            if(board[0][c] == 'O') st.push({0, c});
            if(board[n-1][c] == 'O') st.push({n-1, c});
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

                    if((nrow >=0 and nrow < n) and (ncol >= 0 and ncol < m) and (board[nrow][ncol] == 'O') and !visited[nrow][ncol]){
                        st.push({nrow, ncol});
                    }
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!visited[i][j] and board[i][j] == 'O') board[i][j] = 'X';
            } 
        }
    }
};