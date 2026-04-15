class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < n; i++){
            adj.get(i).add((i+1)%n);
            adj.get(i).add((i-1+n)%n);
        }

        boolean[] visited = new boolean[n];

        Deque<Integer> q = new ArrayDeque<>();
        q.offer(startIndex);
        visited[startIndex] = true;

        int steps = 0;

        System.out.println();

        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){

                int front = q.poll();

                if(words[front].equals(target)) return steps;

                for(int adjNode : adj.get(front)){
                    if(!visited[adjNode]){
                        q.offer(adjNode);
                        visited[adjNode] = true;
                    }
                }
            }
            steps++;
        }

        // System.out.println(adj);

        return -1;
    }
}