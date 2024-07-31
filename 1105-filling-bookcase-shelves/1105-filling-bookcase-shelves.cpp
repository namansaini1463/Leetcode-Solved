class Solution {
private:
    int minHeightShelvesHelper(int idx, int remainingWidth, int currentShelfHeight, int shelfWidth, vector<vector<int>>& books, vector<vector<int>>& dp) {
        if (idx == books.size()) return currentShelfHeight;

        if (dp[idx][remainingWidth] != -1) return dp[idx][remainingWidth];

        int bookWidth = books[idx][0];
        int bookHeight = books[idx][1];

        // Case 1: Placing the book in the current shelf
        int placeInCurrentShelf = INT_MAX;
        if (bookWidth <= remainingWidth) {
            placeInCurrentShelf = minHeightShelvesHelper(idx + 1, remainingWidth - bookWidth, max(currentShelfHeight, bookHeight), shelfWidth, books, dp);
        }

        // Case 2: Placing the book in a new shelf
        int placeInNewShelf = currentShelfHeight + minHeightShelvesHelper(idx + 1, shelfWidth - bookWidth, bookHeight, shelfWidth, books, dp);

        return dp[idx][remainingWidth] = min(placeInCurrentShelf, placeInNewShelf);
    }

public:
    int minHeightShelves(vector<vector<int>>& books, int shelfWidth) {
        int n = books.size();
        vector<vector<int>> dp(n, vector<int>(shelfWidth + 1, -1));
        return minHeightShelvesHelper(0, shelfWidth, 0, shelfWidth, books, dp);
    }
};
