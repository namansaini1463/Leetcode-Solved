class Solution {
    public boolean areSimilar(int[][] mat, int k) {

        int[][] originalMat = new int[mat.length][];
        for (int i = 0; i < mat.length; i++) {
            originalMat[i] = Arrays.copyOf(mat[i], mat[i].length);
        }

        int n = mat.length;
        int m = mat[0].length;

        k = k % m;
        
        // Process the matrix
        for(int i = 0; i < n; i++){
            if(i % 2 == 0){
                int leftPointer = 0, rightPointer =  k - 1;

                // Reverse 0..k-1
                while(leftPointer < rightPointer){
                    int temp = mat[i][leftPointer];
                    mat[i][leftPointer] = mat[i][rightPointer];
                    mat[i][rightPointer] = temp;

                    leftPointer++; rightPointer--;
                }

                // Reverse k...m-1
                leftPointer = k; rightPointer = m-1;
                while(leftPointer < rightPointer){
                    int temp = mat[i][leftPointer];
                    mat[i][leftPointer] = mat[i][rightPointer];
                    mat[i][rightPointer] = temp;

                    leftPointer++; rightPointer--;
                }

                // Reverse 0...m-1
                leftPointer = 0; rightPointer = m-1;
                while(leftPointer < rightPointer){
                    int temp = mat[i][leftPointer];
                    mat[i][leftPointer] = mat[i][rightPointer];
                    mat[i][rightPointer] = temp;

                    leftPointer++; rightPointer--;
                }
            } else {
                int leftPointer = 0, rightPointer =  m - k - 1;

                // Reverse 0..k
                while(leftPointer < rightPointer){
                    int temp = mat[i][leftPointer];
                    mat[i][leftPointer] = mat[i][rightPointer];
                    mat[i][rightPointer] = temp;

                    leftPointer++; rightPointer--;
                }

                // Reverse k+1...m-1
                leftPointer = m - k; rightPointer = m-1;
                while(leftPointer < rightPointer){
                    int temp = mat[i][leftPointer];
                    mat[i][leftPointer] = mat[i][rightPointer];
                    mat[i][rightPointer] = temp;

                    leftPointer++; rightPointer--;
                }

                // Reverse 0...m-1
                leftPointer = 0; rightPointer = m-1;
                while(leftPointer < rightPointer){
                    int temp = mat[i][leftPointer];
                    mat[i][leftPointer] = mat[i][rightPointer];
                    mat[i][rightPointer] = temp;

                    leftPointer++; rightPointer--;
                }
            }
        }

        // Compare the matrix
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(originalMat[i][j] != mat[i][j]) return false;
            }
        }

        // System.out.println(Arrays.deepToString(mat));

        return true;

    }
}