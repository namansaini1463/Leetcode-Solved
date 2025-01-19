class Solution {
  typedef pair<int, pair<int, int>> pipii;

 public:
  int trapRainWater(vector<vector<int>>& heightMap) {
    int n = heightMap.size();
    int m = heightMap[0].size();

    int water = 0;

    priority_queue<pipii, vector<pipii>, greater<>> cells;

    vector<vector<bool>> visited(n, vector<bool>(m, false));

    vector<pair<int, int>> directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    // Step 1: Push all the cells on the border into the priority queue.
    for (int i = 0; i < n; i++) {
      cells.push({heightMap[i][0], {i, 0}});
      cells.push({heightMap[i][m - 1], {i, m - 1}});
      visited[i][0] = visited[i][m - 1] = true;
    }

    for (int j = 1; j < m - 1; j++) {
      cells.push({heightMap[0][j], {0, j}});
      cells.push({heightMap[n - 1][j], {n - 1, j}});
      visited[0][j] = visited[n - 1][j] = true;
    }

    // Step 2: Process the cells in the priority queue.
    while (!cells.empty()) {
      auto [height, coords] = cells.top();
      cells.pop();

      int i = coords.first;
      int j = coords.second;

      for (auto [di, dj] : directions) {
        int new_i = i + di;
        int new_j = j + dj;

        if (new_i > 0 and new_i < n - 1 and new_j > 0 and new_j < m - 1 and
            !visited[new_i][new_j]) {
          visited[new_i][new_j] = true;

          cells.push({max(heightMap[new_i][new_j], height), {new_i, new_j}});

          water += max(0, height - heightMap[new_i][new_j]);
        }
      }
    }

    return water;
  }
};