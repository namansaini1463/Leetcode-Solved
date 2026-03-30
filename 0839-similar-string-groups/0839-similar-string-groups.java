class DSU {
    int[] parent;
    int[] size;
    int components;

    public DSU(int n) {
        this.parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        this.size = new int[n];
        Arrays.fill(size, 1);

        this.components = n;
    }

    public int findUlimateParent(int u) {
        if (u == parent[u])
            return u;

        return parent[u] = findUlimateParent(parent[u]);
    }

    public boolean find(int u, int v) {
        return findUlimateParent(u) == findUlimateParent(v);
    }

    public boolean union(int u, int v) {
        int parentU = findUlimateParent(u);
        int parentV = findUlimateParent(v);

        if (parentU == parentV)
            return false;

        if (size[parentV] > size[parentU]) {
            size[parentV] += size[parentU];
            parent[parentU] = parentV;
        } else {
            size[parentU] += size[parentV];
            parent[parentV] = parentU;
        }

        components--;
        return true;
    }

    public int componentCount() {
        return this.components;
    }

}

class Solution {
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        int stringLength = strs[0].length();

        DSU dsu = new DSU(n);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                int differenceCount = 0;
                for (int idx = 0; idx < stringLength; idx++) {
                    if (strs[i].charAt(idx) != (strs[j].charAt(idx))) {
                        differenceCount++;
                    }
                }
                // Either same strings or string with difference 2
                if (differenceCount == 0 || differenceCount == 2) {
                    dsu.union(i, j);
                    // System.out.println(strs[i] + " " + strs[j]);
                }
            }
        }

        return dsu.componentCount();
    }
}