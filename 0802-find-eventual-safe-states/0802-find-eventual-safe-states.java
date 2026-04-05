class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        List<List<Integer>> reversed = new ArrayList<>();
        for(int i = 0; i < n; i++){
            reversed.add(new ArrayList<>());
        }

        int[] indegree = new int[n];

        for(int node = 0; node < n; node++){
            for(int adjNode : graph[node]){
                reversed.get(adjNode).add(node);
                // System.out.println(adjNode + " -> " + node);
                indegree[node]++;
            }
        }

        Deque<Integer> q = new ArrayDeque<>();

        for(int i = 0; i < n; i++){
            if(indegree[i] == 0) q.offer(i);
        }

        List<Integer> result = new ArrayList<>();

        while(!q.isEmpty()){
            int node = q.poll();
            result.add(node);

            for(int adjNode : reversed.get(node)){
                indegree[adjNode]--;

                if(indegree[adjNode] == 0){
                    q.offer(adjNode);
                }
            }
        }

        Collections.sort(result);

        // System.out.println(reversed);
        // System.out.println(Arrays.toString(indegree));

        return result;
    }
}