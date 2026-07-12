class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        
        int[][] arrWithIdx = new int[n][2];
        for(int i = 0; i < n; i++){
            arrWithIdx[i][0] = arr[i];
            arrWithIdx[i][1] = i;
        }

        int[] result = new int[n];


        Arrays.sort(arrWithIdx, (a, b) -> Integer.compare(a[0], b[0]));

        int i = 0, j = 0, rank = 1;
        while(j < n){
            if(arrWithIdx[i][0] != arrWithIdx[j][0]) {
                i = j; rank++;
            }

            result[arrWithIdx[j][1]] = rank;

            j++;
        }

        // System.out.println(Arrays.deepToString(arrWithIdx))
        return result;
    }
}