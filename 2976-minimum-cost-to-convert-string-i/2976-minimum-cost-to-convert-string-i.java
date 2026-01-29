class Solution {
    private void addMinimumEdge(List<List<int[]>> adj, int u, int v, int w){
        for(int[] edge : adj.get(u)){
            int from = edge[0];
            int weight = edge[1];

            if(from == v){
                edge[1] = Math.min(weight, w);
                return;
            }
        }

        adj.get(u).add(new int[]{v, w});
    }


    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int n = original.length;

        int sourceLength = source.length();

        int[][] allPairMinDistances = new int[26][26];
        for(int u = 0; u < 26; u++){
            for(int v = 0; v < 26; v++){
                allPairMinDistances[u][v] = (u == v ) ?  0 : (int)1e9;
            }
        }

        for (int i = 0; i < n; i++) {
            int u = original[i] - 'a';
            int v = changed[i] - 'a';
            int w = cost[i];

            allPairMinDistances[u][v] = Math.min(allPairMinDistances[u][v], w);
        }


        for(int via = 0; via < 26; via++){
            for(int u = 0; u < 26; u++){
                for(int v = 0; v < 26; v++){
                    allPairMinDistances[u][v] = Math.min(allPairMinDistances[u][v], allPairMinDistances[u][via] +  allPairMinDistances[via][v]);
                }
            }
        }

        long minCost = 0;
        for(int i = 0; i < sourceLength; i++){
            int u = source.charAt(i) - 'a';
            int v = target.charAt(i) - 'a';


            if(allPairMinDistances[u][v] == (int)1e9) return -1;
            
            minCost += allPairMinDistances[u][v];
        }

        // System.out.println(Arrays.deepToString(allPairMinDistances));
        

        // for (int u = 0; u < adjList.size(); u++) {
        //     System.out.print(u + " -> ");
        //     for (int[] edge : adjList.get(u)) {
        //         System.out.print("(" + edge[0] + ", " + edge[1] + ") ");
        //     }
        //     System.out.println();
        // }

        return minCost;
    }
}