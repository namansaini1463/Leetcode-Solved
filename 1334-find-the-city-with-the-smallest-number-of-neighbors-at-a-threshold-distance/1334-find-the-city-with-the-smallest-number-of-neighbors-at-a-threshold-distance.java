class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] shortestPaths = new int[n][n];


        for(int i = 0; i < n; i++){
            Arrays.fill(shortestPaths[i], (int)1e9);

            shortestPaths[i][i] = 0;
        }

        for(int[] edge : edges){
            int u = edge[0], v = edge[1], w = edge[2];

            shortestPaths[u][v] = w;
            shortestPaths[v][u] = w;
        }

        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    shortestPaths[i][j] = Math.min(
                        shortestPaths[i][j],
                        shortestPaths[i][k] + shortestPaths[k][j]
                    );
                }
            }
        }

        int minimumCityCount = n;
        int resultCity = 0;

        for(int city = 0; city < n; city++){
            int cityCount = 0;
            for(int i = 0; i < n; i++){
                if(city == i) continue;

                if(shortestPaths[city][i] <= distanceThreshold) cityCount++;
            }

            if(cityCount <= minimumCityCount){
                resultCity = city;
                minimumCityCount = cityCount;
            }
        }

        // System.out.println(Arrays.deepToString(shortestPaths));

        return resultCity;
        
    }
}