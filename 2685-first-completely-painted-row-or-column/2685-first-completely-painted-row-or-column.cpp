class Solution {
public:
     int firstCompleteIndex(vector<int>& arr, vector<vector<int>>& mat) {
        int n = mat.size(), m = mat[0].size();

        unordered_map<int, pair<int, int>> coordinates;

        // Store the coordinates of the number from the matrix to the map
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                coordinates[mat[i][j]] = {i, j};
            }
        }

        vector<int> trackRow(n, 0), trackCol(m, 0);


        for(int i = 0; i < arr.size(); i++){
            int row = coordinates[arr[i]].first;
            int col = coordinates[arr[i]].second;

            trackRow[row]++;
            trackCol[col]++;

            if(trackRow[row] == m or trackCol[col] == n){
                return i;
            }
        }

        return -1; 
    }
};