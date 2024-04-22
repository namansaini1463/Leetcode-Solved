class Solution {
public:
    // 0 based indexing
    /*
        This question is on topological sorting on graphs
        - If there is any cycle in the graph, then we would not be able to complete all the courses
            as can be seen in example 2
        - So basically, we need to detect if no cycle exists in the graph, or that whether or not a topological sort exists for the given set of edges
        - prerequisites[i] = [ai, bi]  represents a directed edge from ai to bi
    */
    /*
        Using Kahn's Algorithm to solve the question
        (Topological sort, using BFS)
        (INDEGREE)
    */
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        // Converting the edges into adjacency list
        vector<int> adj[numCourses];
        // Creating an array to keep track of the indegree of each node in the graph
        int indegree[numCourses];
        fill_n(indegree, numCourses, 0);

        for(const auto &prerequisite : prerequisites){
            int src = prerequisite[0];
            int dst = prerequisite[1];

            adj[src].push_back(dst);
            indegree[dst]++;
        }

        vector<int> topoSort;
        queue<int> q;
        for(int i = 0; i < numCourses; i++){
            if(!indegree[i]) q.push(i);
        }

        while(!q.empty()){
            int node = q.front(); q.pop();
            topoSort.push_back(node);

            for(const auto &adjNode : adj[node]){
                indegree[adjNode]--;

                if(!indegree[adjNode]) q.push(adjNode);
            }
        }

        // if the topological sort contains all the courses, then we can take all the courses. Otherwise not
        return topoSort.size() == numCourses;

    }
};