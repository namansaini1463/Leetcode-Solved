class DSU {
    int[] parent;
    // int[] size;

    public DSU(int n) {
        this.parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        // this.size = new int[n];
        // Arrays.fill(size, 1);
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

        // System.out.println("Merging " + (char) (u + 'a') + " " + (char) (v + 'a'));
        // System.out.println("Merging " + u + " " + v);

        if (parentU < parentV) {
            parent[parentV] = parentU; 
            // size[parentU] += size[parentV];
        } else {
            parent[parentU] = parentV; 
            // size[parentV] += size[parentU];
        }

        return true;
    }
}

class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int n = s1.length();
        DSU dsu = new DSU(26); // 26 letters in the alphabet

        for (int i = 0; i < n; i++) {
            int u = (int) (s1.charAt(i) - 'a');
            int v = (int) (s2.charAt(i) - 'a');

            dsu.union(u, v);
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : baseStr.toCharArray()) {
            sb.append((char) (dsu.findUltimateParent(ch - 'a') + 'a'));
        }

        // System.out.println(Arrays.toString(dsu.parent));

        return sb.toString();

    }
}