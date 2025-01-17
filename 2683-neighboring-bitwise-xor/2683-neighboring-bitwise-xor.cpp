class Solution {
public:
    bool doesValidArrayExist(vector<int>& derived) {
        int result = 0;

        for(const auto &num : derived){
            result = result ^ num;
        }

        return !result;
    }
};