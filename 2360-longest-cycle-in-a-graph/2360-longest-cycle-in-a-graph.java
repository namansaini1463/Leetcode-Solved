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