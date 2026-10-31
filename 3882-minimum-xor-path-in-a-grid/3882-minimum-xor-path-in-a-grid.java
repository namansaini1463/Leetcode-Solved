class Solution {
    public int minCost(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][][] dp = new boolean[n][m][1024];

        dp[0][0][grid[0][0]] = true;

        for(int i = 1; i < n; i++){
            boolean[] XORArray = dp[i-1][0];

            for(int idx = 0; idx < 1024; idx++){
                if(XORArray[idx]){
                    dp[i][0][idx ^ grid[i][0]] = true;
                }
            }
        }

        for(int j = 1; j < m; j++){
            boolean[] XORArray = dp[0][j-1];

            for(int idx = 0; idx < 1024; idx++){
                if(XORArray[idx]){
                    dp[0][j][idx ^ grid[0][j]] = true;
                }
            }
        }

        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                boolean[] XORArray_above = dp[i-1][j];

                for(int idx = 0; idx < 1024; idx++){
                    if(XORArray_above[idx]){
                        dp[i][j][idx ^ grid[i][j]] = true;
                    }
                }
                boolean[] XORArray_left = dp[i][j-1];

                for(int idx = 0; idx < 1024; idx++){
                    if(XORArray_left[idx]){
                        dp[i][j][idx ^ grid[i][j]] = true;
                    }
                }
            }
        }

        // find the minium value in the cell n-1,m-1
        for(int idx = 0; idx < 1024; idx++){
            boolean[] XORArray = dp[n-1][m-1];

            if(XORArray[idx])
               return idx;
            
        }


        return -1;


    }
}