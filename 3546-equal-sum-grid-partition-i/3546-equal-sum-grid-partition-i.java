class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        long totalSum = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                totalSum += grid[i][j];
            }
        }

        // Trying all horizontal cuts
        long upperSum = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                upperSum += grid[i][j];
            }

            long lowerSum = totalSum - upperSum;

            if(upperSum == lowerSum) return true;
        }

        // Trying all possible verical cuts
        long leftSum = 0;
        for(int j = 0; j < m; j++){
            for(int i = 0; i < n; i++){
                leftSum += grid[i][j];
            }

            long rightSum = totalSum - leftSum;

            if(rightSum == leftSum) return true;
        }

        return false;
    }
}