class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] result = new int[n - k + 1][m - k + 1];

        for (int i = 0; i < n - k + 1; i++) {
            for (int j = 0; j < m - k + 1; j++) {
                // Process every submatrix
                Set<Integer> subMatrixList = new TreeSet<>();

                for (int r = i; r < i + k; r++) {
                    for (int c = j; c < j + k; c++) {
                        subMatrixList.add(grid[r][c]);
                        // System.out.print(grid[r][c] + " ");
                    }
                    // System.out.println();
                }

                // Collections.sort(subMatrixList);

                int minimumAbsoluteDifference = Integer.MAX_VALUE;

                Integer prev = null;

                for (int val : subMatrixList) {
                    if (prev != null) {
                        minimumAbsoluteDifference = Math.min(minimumAbsoluteDifference, val - prev);
                    }
                    prev = val;
                }

                // for(int p = 1; p < subMatrixList.size(); p++){
                //     minimumAbsoluteDifference = Math.min(minimumAbsoluteDifference, Math.abs(subMatrixList.get(p) - subMatrixList.get(p-1))  == 0 ? Integer.MAX_VALUE : Math.abs(subMatrixList.get(p) - subMatrixList.get(p-1)));
                // }

                result[i][j] = minimumAbsoluteDifference == Integer.MAX_VALUE ? 0 : minimumAbsoluteDifference;
            }
            // System.out.println();
        }

        return result;

    }
}