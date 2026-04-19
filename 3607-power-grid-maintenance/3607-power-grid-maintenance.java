class DSU{
    int[] parent;
    int[] size;

    public DSU(int n){
        this.parent = new int[n];
        for(int i = 0; i < n; i++) parent[i] = i;

        this.size = new int[n];
        Arrays.fill(size, 1);
    }

    public int findUltimateParent(int u){
        if(parent[u] == u) return u;

        return parent[u] = findUltimateParent(parent[u]);
    }

    public boolean find(int u, int v){
        return findUltimateParent(u) == findUltimateParent(v);
    }

    public boolean union(int u, int v){
        int parentU = findUltimateParent(u);
        int parentV = findUltimateParent(v);

        if(parentU == parentV) return false;

        if(size[parentV] > size[parentU]){
            size[parentV] += size[parentU];
            parent[parentU] = parentV;
        } else {
            size[parentU] += size[parentV];
            parent[parentV] = parentU;
        }

        return true;

    }
}

class Solution {
    public int[] processQueries(int n, int[][] connections, int[][] queries) {

        List<Integer> resultList = new ArrayList<>();
        HashMap<Integer, TreeSet<Integer>> map = new HashMap<>();

        DSU dsu = new DSU(n + 1);

        // Step 1: Build DSU
        for(int[] conn : connections){
            dsu.union(conn[0], conn[1]);
        }

        // Step 2: Build component -> nodes mapping
        for(int i = 1; i <= n; i++){
            int parent = dsu.findUltimateParent(i);
            map.computeIfAbsent(parent, k -> new TreeSet<>()).add(i);
        }

        // Step 3: Process queries
        for(int[] query : queries){

            int type = query[0];
            int node = query[1];

            int parent = dsu.findUltimateParent(node);
            TreeSet<Integer> set = map.get(parent);

            if(type == 1){

                if(set.contains(node)){
                    resultList.add(node);
                } 
                else if(!set.isEmpty()){
                    resultList.add(set.first());
                }
                else{
                    resultList.add(-1);
                }

            }
            else{
                if(set != null){
                    set.remove(node);
                }

            }
        }

        return resultList.stream().mapToInt(i -> i).toArray();
    }
}