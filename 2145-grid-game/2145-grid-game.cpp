class Solution {
public:
    long long gridGame(vector<vector<int>>& grid) {
        long long totalTopRow = accumulate(grid[0].begin(), grid[0].end(), 0LL); // Total sum of the top row
        long long totalBottomRow = 0; // Sum of elements traversed in the bottom row
        long long minMaxSum = LLONG_MAX; // Minimized max sum for Robot2

        for (int col = 0; col < grid[0].size(); ++col) {
            totalTopRow -= grid[0][col]; // Update remaining top row sum after Robot1's move
            long long robot2Max = max(totalTopRow, totalBottomRow); // Best move Robot2 can make
            minMaxSum = min(minMaxSum, robot2Max); // Minimize the maximum sum Robot2 can achieve
            totalBottomRow += grid[1][col]; // Update bottom row sum after Robot1's move
        }

        return minMaxSum;
    }
};
