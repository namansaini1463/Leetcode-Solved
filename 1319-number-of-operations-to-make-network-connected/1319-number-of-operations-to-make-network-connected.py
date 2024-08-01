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
        
        return True



class Solution:
    def makeConnected(self, n: int, connections: List[List[int]]) -> int:
        s1 = DisjointSet(n)

        extraEdges = 0
        connectedComponents = 0

        for u,v in connections:
            if not s1.union(u,v):
                extraEdges += 1

        for i in range(n):
            if s1.find(i) == i:
                connectedComponents += 1
        

        return connectedComponents -1 if (extraEdges >= connectedComponents -1) else -1