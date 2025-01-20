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

//! BRUTE FORCE SOLUTION
// class Solution {
// private:
//     bool checkRow(vector<vector<bool>> &visited){
//         for(int row = 0; row < visited.size(); row++){
//             bool flag = true;
//             for(int col = 0; col < visited[0].size(); col++){
//                 if(!visited[row][col]){
//                     flag = false;
//                     break;
//                 }
//             }
//             if(flag) return true;
//         }
//         return false;
//     }

//     // Check the column is completely painted or not
//     bool checkColumn(vector<vector<bool>> &visited){
//        for(int col = 0; col < visited[0].size(); col++){
//             bool flag = true;
//             for(int row = 0; row < visited.size(); row++){
//                 if(!visited[row][col]){
//                     flag = false;
//                     break;
//                 }
//             }
//             if(flag) return true;
//         }
//         return false;
//     }


// public:
//     int firstCompleteIndex(vector<int>& arr, vector<vector<int>>& mat) {
//         int n = mat.size(), m = mat[0].size();

//         unordered_map<int, pair<int, int>> coordinates;

//         // Store the coordinates of the number from the matrix to the map
//         for(int i = 0; i < n; i++){
//             for(int j = 0; j < m; j++){
//                 coordinates[mat[i][j]] = {i, j};
//             }
//         }

//         // // print the coordinates 
//         // for(auto x: coordinates){
//         //     cout << x.first << " " << x.second.first << " " << x.second.second << endl;
//         // }

//         vector<vector<bool>> visited(n, vector<bool>(m, false));

//         for(int i = 0; i < arr.size(); i++){
//             int row = coordinates[arr[i]].first;
//             int col = coordinates[arr[i]].second;

//             visited[row][col] = true;

//             if(checkRow(visited) || checkColumn(visited)){
//                 return i;
//             }
//         }

//         return -1;        
//     }
// };