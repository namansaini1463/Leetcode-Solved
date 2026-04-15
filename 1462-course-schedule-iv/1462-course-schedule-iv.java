class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        // Create the adjList from the preRequisties
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        for(int[] prereq : prerequisites){
            int u = prereq[0], v = prereq[1];

            adj.get(u).add(v);
            indegree[v]++;
        }
        
        Map<Integer, Set<Integer>> map = new HashMap<>();


        Deque<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0) {
                q.offer(i);
                map.computeIfAbsent(i, k -> new HashSet<>());
            }
        }

        while(!q.isEmpty()){
            int front = q.poll();

            for(int adjNode : adj.get(front)){
                map.computeIfAbsent(adjNode, k -> new HashSet<>());

                map.get(adjNode).add(front);
                map.get(adjNode).addAll(map.get(front));

                indegree[adjNode]--;

                if(indegree[adjNode] == 0){
                    q.offer(adjNode);
                }
            }
        }

        // Process the queries
        List<Boolean> result = new ArrayList<>();
        for(int[] query : queries){
            int u = query[0], v = query[1];

            result.add(map.get(v).contains(u));
        }

        System.out.println(map);

        return result;
    }
}