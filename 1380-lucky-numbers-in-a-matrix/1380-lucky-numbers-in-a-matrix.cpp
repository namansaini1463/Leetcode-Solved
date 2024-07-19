class Solution {
private:
    pair<int, int> findMinimumInRow(int row, vector<vector<int>>& matrix) {
        int cols = matrix[row].size();
        int minElement = matrix[row][0];
        int minCol = 0;
        for(int col = 1; col < cols; col++) {
            if(matrix[row][col] < minElement) {
                minElement = matrix[row][col];
                minCol = col;
            }
        }
        return {minElement, minCol};
    }

    int findMaximumInCol(int col, vector<vector<int>>& matrix) {
        int rows = matrix.size();
        int maxElement = matrix[0][col];
        for(int row = 1; row < rows; row++) {
            maxElement = max(maxElement, matrix[row][col]);
        }
        return maxElement;
    }

public:
    vector<int> luckyNumbers (vector<vector<int>>& matrix) {
        vector<int> result;
        int rows = matrix.size();
        for(int row = 0; row < rows; row++) {
            pair<int, int> temp = findMinimumInRow(row, matrix);
            int minimumElementInCurrentRow = temp.first;
            int minimumElementCol = temp.second;
            int maximumElementInCurrentCol = findMaximumInCol(minimumElementCol, matrix);

            if(minimumElementInCurrentRow == maximumElementInCurrentCol) {
                result.push_back(maximumElementInCurrentCol);
            }
        }
        return result;
    }
};
