class DisjointSet:
    def __init__(self, n):
        self.parent = list(range(n+1))
        self.size = [1]*(n+1)

    def find(self, u):
        if(self.parent[u] == u):
            return u

        self.parent[u] = self.find(self.parent[u])
        return self.parent[u]

    def union(self, u, v):
        rootU = self.find(u)
        rootV = self.find(v)

        if(rootU == rootV):
            return False
        
        if(self.size[rootU] < self.size[rootV]):
            self.parent[rootU] = rootV
            self.size[rootV] += self.size[rootU]
        else:
            self.parent[rootV] = rootU
            self.size[rootU] += self.size[rootV]


class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        n = len(isConnected)
        s1 = DisjointSet(n)

        numProvince = 0

        for i in range(n):
            for j in range(n):
                if(isConnected[i][j] == 1):
                    s1.union(i, j)
        
        for i in range(n):
            if(s1.parent[i] == i): 
                numProvince += 1
                
        return numProvince