class Solution {
public:
    bool canConstruct(string s, int k) {
        // Optimising the code a bit
        if(s.size() < k) return false;
        if(s.size() == k) return true;

        // Creating a frequency array that only stores/tracks the odd chars
        int count[26] = {0};

        for(int i = 0; i < s.size(); i++){
            count[s[i] - 'a'] ^= 1;
        }

        // Count the number of odd chars,
        // If they are less than or equal to 'k', then we can partition the string, otherwise not
        int oddChars = 0;
        for(const auto &i : count){
            oddChars += i;
        }  


        return oddChars <= k ? true : false;
    }
};

