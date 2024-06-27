class Solution {
public:
    int shortestPathBinaryMatrix(vector<vector<int>>& grid) {
        int n = grid.size();
        if (n == 0 or grid[0].size() == 0) return -1;
        if (grid[0][0] == 1 or grid[n-1][n-1] == 1) return -1;

        vector<vector<bool>> visited(n, vector<bool>(n, false));
        vector<vector<int>> directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};

        queue<pair<int, int>> q;
        q.push({0, 0});
        visited[0][0] = true;
        int shortestPathDistance = 1; // Initial distance is 1 (starting cell)

        while (!q.empty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                int x = q.front().first;
                int y = q.front().second;
                q.pop();

                if (x == n - 1 and y == n - 1) return shortestPathDistance;

                for (const auto &direction : directions) {
                    int newX = x + direction[0];
                    int newY = y + direction[1];

                    if ((newX >= 0) and (newX < n) and (newY >= 0) and (newY < n) and grid[newX][newY] == 0 and !visited[newX][newY]) {
                        q.push({newX, newY});
                        visited[newX][newY] = true;
                    }
                }
            }
            shortestPathDistance++;
        }

        return -1;
    }
};