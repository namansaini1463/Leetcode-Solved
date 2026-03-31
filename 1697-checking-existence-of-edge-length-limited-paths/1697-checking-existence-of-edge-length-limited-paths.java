class DSU {
    int[] parent; 
    int[] size;

    public DSU(int n){
        this.parent = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }

        this.size = new int[n];
        Arrays.fill(size, 1);
    }

    private int findUltimateParent(int u){
        if(u == parent[u]) return u;

        return parent[u] = findUltimateParent(parent[u]);
    }

    public boolean find(int u, int v){
        return findUltimateParent(u) == findUltimateParent(v);
    }

    public boolean union(int u, int v){
        int parU = findUltimateParent(u);
        int parV = findUltimateParent(v);

        if(parU == parV) return false;

        if(size[parV] > size[parU]){
            parent[parU] = parV;
            size[parV] += size[parU]; 
        } else {
            parent[parV] = parU;
            size[parU] += size[parV]; 
        }

        return true;
    }
}

class Solution {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        int m = queries.length;
        // result array
        boolean[] result = new boolean[m];

        // Sort the edgelist on the basis of the distance;
        Arrays.sort(edgeList, Comparator.comparingInt(a -> a[2]));

        // Queries order
        Integer[] order = new Integer[m];
        for(int i = 0; i < m; i++){
            order[i] = i;
        }

        // Virtually sort the queries on the basis og the 'limit'
        Arrays.sort(order, Comparator.comparingInt(i -> queries[i][2]));

        DSU dsu = new DSU(n);

        // Process the virtaully sorted queries
        int e = 0;
        for(int q : order){
            int u = queries[q][0], v = queries[q][1], d = queries[q][2];

            while(e < edgeList.length && edgeList[e][2] < d){
                dsu.union(edgeList[e][0], edgeList[e][1]); // Idhar mai edges ko merge krr raha hoon and naaki, query ke u and v ko
                e++;
            }   

            // System.out.println(Arrays.toString(dsu.parent));

           result[q] = dsu.find(u, v);
            
        }
        

        // System.out.println(Arrays.deepToString(edgeList));
        // System.out.println(Arrays.toString(order));

        return result;

    }
}