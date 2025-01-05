class Solution {
public:
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
};