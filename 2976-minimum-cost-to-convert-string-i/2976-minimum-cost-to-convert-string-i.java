class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int n = original.length;
        // source se target jaane ka shortest paths nikaal lunga mai saare
        long[][] dist = new long[26][26];

        for(int i = 0; i < 26; i++){
            Arrays.fill(dist[i], Long.MAX_VALUE);
            dist[i][i] = 0;
        }

        for(int i = 0; i < n; i++){
            dist[(int)original[i] - 'a'][(int)changed[i] - 'a'] = Math.min(cost[i], dist[(int)original[i] - 'a'][(int)changed[i] - 'a']);
        }

        // run floyd warshall to find all pair shortest path
        for(int k = 0; k < 26; k++){
            for(int i = 0; i < 26; i++){
                for(int j = 0; j < 26; j++){
                    if(dist[i][k] == Long.MAX_VALUE || dist[k][j] == Long.MAX_VALUE) continue;

                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        // calculate the cost
        long resultCost = 0;

        int len = source.length();
        for(int i = 0; i < len; i++){
            long currentCost = dist[(int)source.charAt(i) - 'a'][(int)target.charAt(i) - 'a'];
            if(currentCost == Long.MAX_VALUE) return -1;

            resultCost += currentCost;
        }

        return resultCost;
    }
}