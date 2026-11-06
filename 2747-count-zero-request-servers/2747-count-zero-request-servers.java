class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int[] result = new int[queries.length];
        
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));

        List<int[]> q = new ArrayList<>();
        for(int i = 0; i < queries.length; i++){
            q.add(new int[]{i, queries[i]});
        }

        q.sort((a, b) -> Integer.compare(a[1], b[1]));

        int left = 0, right = 0, activeServers = 0;
        int[] freq = new int[n+1];

        for(int[] query : q){
            int ogIndex = query[0];
            int time = query[1];

            while(right < logs.length && logs[right][1] <= time){
                int server = logs[right][0];

                if(freq[server] == 0) activeServers++;

                freq[server]++;
                right++;
            }

            while(left < right && logs[left][1] < time - x){
                int server = logs[left][0];
                freq[server]--;

                if(freq[server] == 0) activeServers--;

                left++;
            }

            result[ogIndex] = n - activeServers;
        }

        // System.out.println(Arrays.deepToString(logs));
        // for(int[] qe : q) System.out.println(Arrays.toString(qe));
        // System.out.println(q);

        return result;
    }
}