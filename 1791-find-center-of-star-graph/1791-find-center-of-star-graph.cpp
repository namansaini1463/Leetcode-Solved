class Solution {
public:
    int findCenter(vector<vector<int>>& edges) {
        // vector<int> edge1 = edges[0];
        // vector<int> edge2 = edges[1];
        
        int src1 = edges[0][0];
        int dst1 = edges[0][1];
        
        int src2 = edges[1][0];
        int dst2 = edges[1][1];
        
        if(src1 == src2 or src1 == dst2) return src1;
        else return dst1;
    }
};