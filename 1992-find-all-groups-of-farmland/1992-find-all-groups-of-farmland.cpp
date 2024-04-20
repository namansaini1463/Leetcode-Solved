class Solution {
public:
    vector<vector<int>> findFarmland(vector<vector<int>>& land) {
        int n = land.size();
        int m = land[0].size();
        vector<vector<int>> result;
        vector<vector<bool>> visited(n, vector<bool>(m, false));

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] and !visited[i][j]) {
                    // New rectangle if land is found and is not visited
                    int r1 = i, c1 = j;
                    int r2 = i, c2 = j;

                    // Expand downwards to find the bottom row of the block
                    while (r2 + 1 < n and land[r2 + 1][j] and !visited[r2 + 1][j]) {
                        r2++;
                    }

                    // Expand rightwards to find the right column of the block
                    bool valid = true;
                    while (c2 + 1 < m and valid) {
                        for (int r = r1; r <= r2; r++) {
                            if (!land[r][c2 + 1] or visited[r][c2 + 1]) {
                                valid = false;
                                break;
                            }
                        }
                        if (valid) c2++;
                    }

                    // Mark all cells in the block as visited
                    for (int r = r1; r <= r2; r++) {
                        for (int c = c1; c <= c2; c++) {
                            visited[r][c] = true;
                        }
                    }

                    // Add the coordinates of this block to the result list
                    result.push_back({r1, c1, r2, c2});
                }
            }
        }

        return result;
    }
};