class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int n = grid.length;
        int m = grid[0].length;

        for (int j = y; j < y + k; j++) {
            int p1 = x, p2 = x + k - 1;

            while (p1 < p2) {
                int temp = grid[p1][j];
                grid[p1][j] = grid[p2][j];
                grid[p2][j] = temp;

                p1++;
                p2--;
            }

        }
        
        return grid;

    }
}