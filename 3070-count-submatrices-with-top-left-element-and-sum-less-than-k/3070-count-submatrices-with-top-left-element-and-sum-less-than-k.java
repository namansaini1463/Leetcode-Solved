class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] preSum = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                preSum[i][j] = grid[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                preSum[i][j] = grid[i][j];
                if (i - 1 >= 0) {
                    preSum[i][j] += preSum[i - 1][j];
                }
                if (j - 1 >= 0) {
                    preSum[i][j] += preSum[i][j - 1];
                }
                if (i - 1 >= 0 && j - 1 >= 0) {
                    preSum[i][j] -= preSum[i - 1][j - 1];
                }
            }
        }

        int subMatricesCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(preSum[i][j] <= k) subMatricesCount++;
            }
        }

        
        return subMatricesCount;
    }
}