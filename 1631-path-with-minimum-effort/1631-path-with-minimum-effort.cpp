typedef pair<int, pair<int, int>> pipii;

class Solution {
public:
    int minimumEffortPath(vector<vector<int>>& heights) {
        int n = heights.size();
        int m = heights[0].size();

        int deltaRow[] = {-1, 0, +1, 0};
        int deltaCol[] = {0, +1, 0, -1};

        vector<vector<int>> effort(n, vector<int>(m, INT_MAX));
        effort[0][0] = 0;

        // {effort, {row, col}}
        priority_queue<pipii, vector<pipii>, greater<pipii>> pq;
        pq.push({0, {0,0}});

        while(!pq.empty()){
            int eff = pq.top().first;
            int row = pq.top().second.first;
            int col = pq.top().second.second;
            pq.pop();

            if(row == n-1 and col == m-1) return eff;

            for(int i = 0; i < 4; i++){
                int newRow = row + deltaRow[i];
                int newCol = col + deltaCol[i];

                if(newRow >= 0 and newRow < n and newCol >= 0 and newCol < m){
                    int newEffort = max(abs(heights[row][col] - heights[newRow][newCol]), eff);

                    if(newEffort < effort[newRow][newCol]){
                        effort[newRow][newCol] = newEffort;
                        pq.push({newEffort, {newRow, newCol}});
                    }
                }
            }
        }

        return -1;
    }
};