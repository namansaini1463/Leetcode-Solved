class Solution {
    public int[] countOfPairs(int n, int x, int y) {
        int[][] graph = new int[n][n];

        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(graph[i], (int)1e9);
            graph[i][i] = 0;
        }
        for (int i = 0; i < n - 1; i++) {
            graph[i][i+1] = 1;
            graph[i+1][i] = 1;
        }

        graph[x-1][y-1] = 1;
        graph[y-1][x-1] = 1;

        // for (int i = 0; i < n; i++) {
        //     System.out.println(Arrays.toString(graph[i]));
        // }

        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }
        for(int d = 1; d <= n; d++){
            int count = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(graph[i][j] == d && (i != j)) count++;
                }
            }
            result[d-1] = count;
        }

        // for (int i = 0; i < n; i++) {
        //     System.out.println(Arrays.toString(graph[i]));
        // }

        return result;
    }
}