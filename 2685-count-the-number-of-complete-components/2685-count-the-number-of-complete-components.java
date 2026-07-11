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

    public int findUltimateParent(int u) {
        if (u == parent[u])
            return u;

        return parent[u] = findUltimateParent(parent[u]);
    }

    public boolean find(int u, int v) {
        return findUltimateParent(u) == findUltimateParent(v);
    }

    public boolean union(int u, int v) {
        int parentU = findUltimateParent(u);
        int parentV = findUltimateParent(v);

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
}

class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        DSU dsu = new DSU(n);

        int[] degree = new int[n];

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            dsu.union(u, v);

            // increment the degree
            degree[u]++;
            degree[v]++;
        }

        int count = 0;

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int parent = dsu.parent[i];

            map.computeIfAbsent(parent, k -> new ArrayList<>()).add(i);
        }

        for (List<Integer> componentNodes : map.values()) {
            int size = componentNodes.size();

            boolean complete = true;
            for (int node : componentNodes) {
                if (degree[node] != size - 1) {
                    complete = false;
                    break;
                }
            }

            if(complete) count++;
        }

        return count;
    }
}