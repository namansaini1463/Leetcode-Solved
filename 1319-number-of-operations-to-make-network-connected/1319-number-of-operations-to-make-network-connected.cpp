class DisjointSet{
public:
    vector<int> parent, size;

    DisjointSet(int n){
        size.resize(n, 1);
        parent.resize(n);

        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
    }

    int find(int u){
        if(parent[u] == u) return u;

        return parent[u] = find(parent[u]);
    }

    bool unionUV(int u, int v){
        int rootU = find(u);
        int rootV = find(v);

        if(rootU == rootV) return false;

        if(size[rootU] < size[rootV]){
            parent[rootU] = rootV;
            size[rootV] += size[rootU];
        } else {
            parent[rootV] = rootU;
            size[rootU] += size[rootV];
        }

        return true;
    }
};

class Solution {
public:
    int makeConnected(int n, vector<vector<int>>& connections) {
        DisjointSet s1(n);

        int numDisconnectedComponents = 0;
        int extraEdges = 0;

        for(const auto &connection : connections){
            int u = connection[0];
            int v = connection[1];

            if(!s1.unionUV(u,v)) extraEdges++;
        }

        for(int i = 0; i < n; i++){
            if(s1.parent[i] == i) numDisconnectedComponents++;
        }

        return (extraEdges >= numDisconnectedComponents - 1) ? numDisconnectedComponents - 1 : -1;
        
    }
};