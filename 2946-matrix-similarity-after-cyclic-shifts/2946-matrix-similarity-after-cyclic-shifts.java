class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int n = mat.length, m = mat[0].length;
        k = k % m;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int shiftedIndex = (i % 2 == 0)
                    ? (j + k) % m        // left shift
                    : (j - k + m) % m;   // right shift

                if (mat[i][j] != mat[i][shiftedIndex]) return false;
            }
        }

        return true;
    }
}