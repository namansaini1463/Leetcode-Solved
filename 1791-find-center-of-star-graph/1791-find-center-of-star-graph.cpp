class Solution {
public:
    int findCenter(vector<vector<int>>& edges) {
        int src1 = edges[0][0];
        int dst1 = edges[0][1];
        
        int src2 = edges[1][0];
        int dst2 = edges[1][1];
        
        if(src1 == src2 or src1 == dst2) return src1;
        else return dst1;
        
        // int n = edges.size() + 1;
        // vector<int> degree(n+1);

        // for(const auto &edge : edges){
        //     degree[edge[0]]++;
        //     degree[edge[1]]++;
        // }

        // for(int i = 0; i < n+1; i++){
        //     if(degree[i] > 1) return i;
        // }

        // return -1;
    }
};