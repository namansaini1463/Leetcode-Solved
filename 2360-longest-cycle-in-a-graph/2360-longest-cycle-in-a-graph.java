class Solution {
    public int longestCycle(int[] edges) {
        int n = edges.length;

        int[] timeStamp = new int[n];
        Arrays.fill(timeStamp, -1);
        
        int time = 0;
        int maxCycle = -1;

        for(int node = 0; node < n; node++){
            if(timeStamp[node] == -1){ 

                int startTime = time;
                int currentNode = node;

                while(currentNode != -1 && timeStamp[currentNode] == -1){
                    timeStamp[currentNode] = time++;
                    currentNode = edges[currentNode];
                }

                if(currentNode != -1 && timeStamp[currentNode] >= startTime) {
                    maxCycle = Math.max(maxCycle, time - timeStamp[currentNode]);
                }
            }
        }

        return maxCycle;
    }
}



/*
class Solution {
    public int longestCycle(int[] edges) {
        int n = edges.length;

        int[] indegree = new int[n];
        for(int edge : edges){
            if(edge == -1) continue;

            indegree[edge]++;
        }

        Deque<Integer> topoSortQueue = new ArrayDeque<>();
        
        for(int i = 0; i < n; i++){
            if(indegree[i] == 0) topoSortQueue.offer(i);
        }

        while(!topoSortQueue.isEmpty()){
            int first = topoSortQueue.poll();

            int adj = edges[first];
            if(adj != -1){
                indegree[adj]--;
                if(indegree[adj] == 0) topoSortQueue.offer(adj);
            }
        }

        int maxCycleLength = -1;
        for(int i = 0; i < n; i++){
            if(indegree[i] > 0){
                int cycleLength = 0;
                while(indegree[i] > 0){
                    indegree[i]--;
                    i = edges[i];
                    cycleLength++;
                
                }
                maxCycleLength = Math.max(maxCycleLength, cycleLength);
            }
        }

        // System.out.println(Arrays.toString(indegree));

        return maxCycleLength;
    }
}
*/

/** 
class Solution {
    public int dfsAndCount(int node, int n, int[] edges, boolean[] visited, boolean[] inRecursion, int[] size){
        inRecursion[node] = true;
        visited[node] = true;

        int adjNode = edges[node];

        if(adjNode != -1){
            if(!visited[adjNode]){
                size[adjNode] = size[node] + 1;

                int cycleLength = dfsAndCount(adjNode, n, edges, visited, inRecursion, size);
                if(cycleLength != -1){
                    inRecursion[node] = false;
                    return cycleLength;
                }
            } 
            if(visited[adjNode] && inRecursion[adjNode]) {
                inRecursion[node] = false;
                return size[node] - size[adjNode] + 1;
            }
        }

        inRecursion[node] = false;
        return -1;
    }

    public int longestCycle(int[] edges) {
        int n = edges.length;

        boolean[] visited = new boolean[n];
        boolean[] inRecursion = new boolean[n];


        int maxCycle = -1;

        for(int node = 0; node < n; node++){
            if(!visited[node]){
                int[] size = new int[n]; // Reset the size/depth of the DFS for each call
                size[node] = 1;

                maxCycle = Math.max(maxCycle, dfsAndCount(node, n, edges, visited, inRecursion, size));
            }
        }

        return maxCycle;
    }
}
*/