class Solution {
    public int numSpecial(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;

        int[] oneRows = new int[r];
        int[] oneCols = new int[c];

        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(mat[i][j] == 1){
                    oneRows[i]++;
                    oneCols[j]++;
                }
            }
        }

        int specialNums = 0;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(mat[i][j] == 1 && oneRows[i] == 1 && oneCols[j] == 1){
                    specialNums++;
                }
            }
        }

        // System.out.println(Arrays.toString(oneRows));
        // System.out.println(Arrays.toString(oneCols));

        return specialNums;
    }
}