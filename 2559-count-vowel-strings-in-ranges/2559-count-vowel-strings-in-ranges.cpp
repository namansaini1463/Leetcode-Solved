class Solution {
private:
    bool isVowel(char ch) {
        unordered_set<char> vowels = {'a', 'e', 'i', 'o', 'u'};
        return vowels.count(ch) > 0;
    }

    bool checkString(const string& s) {
        return isVowel(s.front()) and isVowel(s.back());
    }
public:
    vector<int> vowelStrings(vector<string>& words, vector<vector<int>>& queries) {
        vector<int> result;

        vector<int> prefixSum(words.size(), 0);

        // Calculating prefix sum for words that start and end with vowels
        for (int i = 0; i < words.size(); i++) {
            if (i == 0) {
                // For the first element, directly assign because there is no `i-1` index
                prefixSum[i] = checkString(words[i]) ? 1 : 0;
            } else {
                // Add the current value to the previous prefix sum
                if (checkString(words[i])) {
                    prefixSum[i] = prefixSum[i - 1] + 1;
                } else {
                    prefixSum[i] = prefixSum[i - 1];
                }
            }
        }

        // Process each query
        for (const auto &query : queries) {
            int left = query[0];
            int right = query[1];

            // Use prefix sum to calculate the result for the range
            if (left == 0) {
                result.push_back(prefixSum[right]);
            } else {
                result.push_back(prefixSum[right] - prefixSum[left - 1]);
            }
        }

        return result;
    }
};