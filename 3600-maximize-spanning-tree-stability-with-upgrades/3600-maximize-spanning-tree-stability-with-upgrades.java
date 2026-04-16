class DSU{
    int parent[];
    int size[];
    int components;

    public DSU(int n){
        this.parent = new int[n];
        for(int i = 0; i < n; i++){
            this.parent[i] = i;
        }

        this.size = new int[n];
        Arrays.fill(size, 1);

        this.components = n;
    }

    private int findUltimateParent(int u){
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
            parent[parentU] = parentV;
            size[parentV] += size[parentU];
        } else {
            parent[parentV] = parentU;
            size[parentU] += size[parentV];
        }

        components--;
        return true;
    }
}

class Solution {
    public int maxStability(int n, int[][] edges, int k) {
        // Binary search on answer
        int lo = 0, hi = 200001, ans = -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (canAchieve(n, edges, k, mid)) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return ans;
    }

    private boolean canAchieve(int n, int[][] edges, int k, int minStr) {
        DSU dsu = new DSU(n);
        int upgradesUsed = 0;

        // Step 1: Must edges — no choice
        for (int[] e : edges) {
            int u = e[0], v = e[1], s = e[2], must = e[3];
            if (must == 1) {
                if (s < minStr) return false; // can't upgrade must edges
                if (!dsu.union(u, v)) return false; // cycle among must edges
            }
        }

        // Step 2: Free optional edges (strength already >= minStr, no upgrade needed)
        for (int[] e : edges) {
            int u = e[0], v = e[1], s = e[2], must = e[3];
            if (must == 0 && s >= minStr) {
                dsu.union(u, v); // greedily add, no upgrade cost
            }
        }

        // Step 3: Upgrade-needed optional edges (2*s >= minStr, costs 1 upgrade)
        for (int[] e : edges) {
            int u = e[0], v = e[1], s = e[2], must = e[3];
            if (must == 0 && s < minStr && 2 * s >= minStr) {
                if (!dsu.find(u, v)) {
                    if (upgradesUsed < k) {
                        dsu.union(u, v);
                        upgradesUsed++;
                    }
                }
            }
        }

        return dsu.components == 1;
    }
}

// class Solution {
//     public int maxStability(int n, int[][] edges, int k) {
//         // jinn bhi nodes ki stability sabze zyada hai and wo must nhi hai unn sabko mai include krr lugna
//         DSU dsu = new DSU(n);

//         int mstCost = 0;
//         int minimumEdge = Integer.MAX_VALUE;


//         for(int[] edge : edges){
//             int u = edge[0], v = edge[1], s = edge[2], must = edge[3];

//             // add all the mandatory edges
//             if(must == 1){
//                 if(dsu.union(u, v)){
//                     System.out.printf("Picked edge %d-%d\n", u, v);
//                     mstCost += s;
//                     minimumEdge = Math.min(minimumEdge, s);
//                 } else {
//                     return -1;
//                 }
//             }
//         }

//         Arrays.sort(edges, Comparator.comparingInt((int[] a) -> a[2]).reversed());
//         System.out.println(Arrays.deepToString(edges));

//         for(int[] edge : edges){
//             int u = edge[0], v = edge[1], s = edge[2], must = edge[3];

//             // Handle the temporary edges
//             if(must == 0){
//                 if(dsu.union(u, v)){
//                     System.out.printf("Picked edge %d-%d\n", u, v);
//                     if(k-- > 0){
//                         mstCost += 2 * s;
//                         minimumEdge = Math.min(minimumEdge, 2*s);
//                     } else {
//                         mstCost +=  s;
//                         minimumEdge = Math.min(minimumEdge, s);
//                     }
//                 }
//             }
//         }

//         return minimumEdge;
//     }
// }