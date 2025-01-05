class Solution {
public:
/*
    string shiftingLetters(string s, vector<vector<int>>& shifts) {
        int n = s.size();

        vector<int> movements(n, 0);
        for(const auto &shift : shifts){
            int startIndex = shift[0];
            int endIndex = shift[1];
            int direction = shift[2];

            for(int i = startIndex; i <= endIndex; i++){
                movements[i] = direction ? movements[i] + 1 : movements[i] - 1;
            }
        }

        for(int i = 0; i < n; i++){
            s[i] = 'a' + (s[i] - 'a' + movements[i] % 26 + 26) % 26;
        }

        return s;

    }
*/
    string shiftingLetters(string s, vector<vector<int>>& shifts) {
        int n = s.size();
        vector<int> movements(n + 1, 0);  // Difference array (size n + 1)

        // Process shifts using the difference array
        for (const auto &shift : shifts) {
            int startIndex = shift[0];
            int endIndex = shift[1];
            int direction = shift[2];

            movements[startIndex] += direction ? 1 : -1;
            movements[endIndex + 1] += direction ? -1 : 1;
        }

        // Compute the prefix sum for actual movements
        for (int i = 1; i < n; i++) {
            movements[i] += movements[i - 1];
        }

        // Apply shifts to the string
        for (int i = 0; i < n; i++) {
            int shiftValue = (movements[i] % 26 + 26) % 26; // Ensure non-negative
            s[i] = 'a' + (s[i] - 'a' + shiftValue) % 26;
        }

        return s;
    }

};