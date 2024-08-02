class DisjointSet{
public:
    vector<int> parent, size;

    DisjointSet(int n){
        parent.resize(n+1);
        for(int i = 0; i < n+1; i++){
            parent[i] = i;
        }

        size.resize(n+1, 1);
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
    int largestIsland(vector<vector<int>>& grid) {
        int n = grid.size(), m = grid[0].size();

        DisjointSet s1(n*m);
        
        int largestIslandSize = 0;

        for(int row = 0; row < n; row++){
            for(int col = 0; col < m; col++){
                if(!grid[row][col]) continue;

                int dr[] = {-1, 0, 1, 0};
                int dc[] = {0, 1, 0, -1};

                for(int i = 0; i < 4; i++){
                    int newRow = row + dr[i];
                    int newCol = col + dc[i];

                    if(newRow >= 0 and newRow < n and newCol >= 0 and newCol < m and grid[newRow][newCol]){
                        int nodeID = row * m + col;
                        int adjNodeID = newRow * m + newCol;
                        s1.unionUV(nodeID, adjNodeID);
                    }
                }
            }
        }
        for(int row = 0; row < n; row++){
            for(int col = 0; col < m; col++){
                if(!grid[row][col]){
                    int dr[] = {-1, 0, 1, 0};
                    int dc[] = {0, 1, 0, -1};
                    set<int> components;

                    for(int i = 0; i < 4; i++){
                        int newRow = row + dr[i];
                        int newCol = col + dc[i];

                        if(newRow >= 0 and newRow < n and newCol >= 0 and newCol < m and grid[newRow][newCol]){
                            components.insert(s1.find(newRow * m + newCol));
                        }
                    }

                    int totalSize = 0;
                    for(const auto &comp : components){
                        totalSize += s1.size[comp];
                    }
                    totalSize += 1;

                    largestIslandSize = max(largestIslandSize, totalSize);

                }
            }
        }

        for(int i = 0; i < n*m; i++){
            largestIslandSize = max(largestIslandSize, s1.size[s1.find(i)]);
        }



        return largestIslandSize;

    }
};