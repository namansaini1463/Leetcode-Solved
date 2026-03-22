class Solution {
    private int[][] rotate(int[][] mat){
        int n = mat.length;
        int[][] result = new int[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                result[j][n - i - 1] = mat[i][j];
            }
        }

        return result;
    }

    private boolean equals(int[][] a, int[][] b){
        int n = a.length;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(a[i][j] != b[i][j]) return false;
            }
        }

        return true;
    }

    public boolean findRotation(int[][] mat, int[][] target) {

        for(int i = 0; i < 4; i++){
            if(equals(mat, target)) return true;
            mat = rotate(mat);
        }

        return false;
    }
}