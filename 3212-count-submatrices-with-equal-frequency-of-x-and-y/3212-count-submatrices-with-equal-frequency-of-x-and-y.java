class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][][] frequencyMatrix = new int[n][m][2];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                frequencyMatrix[i][j][0] = (grid[i][j] == 'X' ? 1 : 0);
                frequencyMatrix[i][j][1] = (grid[i][j] == 'Y' ? 1 : 0);

                if(i - 1 >= 0){
                    frequencyMatrix[i][j][0] += frequencyMatrix[i-1][j][0];
                    frequencyMatrix[i][j][1] += frequencyMatrix[i-1][j][1];
                }
                if(j - 1 >= 0){
                    frequencyMatrix[i][j][0] += frequencyMatrix[i][j-1][0];
                    frequencyMatrix[i][j][1] += frequencyMatrix[i][j-1][1];
                }
                if(i-1 >= 0 && j - 1 >= 0){
                    frequencyMatrix[i][j][0] -= frequencyMatrix[i-1][j-1][0];
                    frequencyMatrix[i][j][1] -= frequencyMatrix[i-1][j-1][1];
                }
            }
        }

        int subMatrixCount = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(frequencyMatrix[i][j][0] > 0 && frequencyMatrix[i][j][0] == frequencyMatrix[i][j][1]) subMatrixCount++;
            }
        }

        // System.out.println(Arrays.deepToString(frequencyMatrix));

        return subMatrixCount;
    }
}