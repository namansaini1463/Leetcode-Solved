class Solution {
    private Map<Integer, TreeSet<Integer>> map = new HashMap<>();
    private ArrayList<Integer> stationToGrid;
    private boolean[] isOffline;
    private int connectionsCount = 0;

    public void dfs(int u, boolean[] visited, ArrayList<ArrayList<Integer>> adjList, TreeSet<Integer> connectedNodes){
        visited[u] = true;
        connectedNodes.add(u);
        stationToGrid.set(u, connectionsCount);

        for(int v : adjList.get(u)){
            if(!visited[v]){
                dfs(v, visited, adjList, connectedNodes);
            }
        }
    }

    public int countAndInitializeMap(int c, ArrayList<ArrayList<Integer>> adjList){
        // Visited array
        boolean[] visited = new boolean[c+1];

        for(int i = 1; i <= c; i++){
            if(!visited[i]){
                connectionsCount++;
                TreeSet<Integer> connectedNodes = new TreeSet<>();
                dfs(i, visited, adjList, connectedNodes);
                // System.out.println(connectionsCount + " : " + connectedNodes);
                map.put(connectionsCount, connectedNodes);
            }
        }

        return connectionsCount;
    }
    
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        this.isOffline = new boolean[c+1];
        this.stationToGrid = new ArrayList<>(Collections.nCopies(c+1, -1));

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>(Collections.nCopies(c+1, null));
        for(int i = 1; i <= c; i++){
            adjList.set(i, new ArrayList<Integer>());
        }

        for(int connection[] : connections){
            int u = connection[0];
            int v = connection[1];

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        // System.out.println(adjList.toString());
        // System.out.println(countAndInitializeMap(c, adjList));
        countAndInitializeMap(c, adjList);
        // System.out.println(map);
        // System.out.println(stationToGrid);

        // Initialize resultList
        ArrayList<Integer> result = new ArrayList<>();

        // Process Queries
        for(int[] query : queries){
            int type = query[0];
            int station = query[1];

            if(type == 1){
                if(this.isOffline[station]){
                    int grid = stationToGrid.get(station);

                    boolean smallestFound = false;
                    
                    while(map.get(grid).size() > 0){
                        int gridSmallest = map.get(grid).first();

                        if(this.isOffline[gridSmallest]) {
                            map.get(grid).pollFirst();
                        } else {
                            result.add(gridSmallest); 
                            smallestFound = true;
                            break;
                        }
                    }

                    if(!smallestFound){
                        result.add(-1);
                    }
                    
                } else {
                    result.add(station);
                }
            } else if(type == 2){
                this.isOffline[station] = true;
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}