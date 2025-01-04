class Solution {
public:
    int countPalindromicSubsequence(string s) {
        // Creating a set to strore all the unique characters in the string
        unordered_set<char> stringChars;
        for(const auto &ch : s){
            stringChars.insert(ch);
        }

        int uniquePalindromicSubsequencesCount = 0;

        for(const auto &ch : stringChars){
            int firstOccuranceFromLeft = 0;
            int firstOccuranceFromRight = 0;

            for(int i = 0; i < s.size(); ++i){
                if(s[i] == ch) {
                    firstOccuranceFromLeft = i;
                    break;
                }
            }

            for(int i = s.size() - 1; i >= 0; --i){
                if(s[i] == ch) {
                    firstOccuranceFromRight = i;
                    break;
                }
            }

            if(firstOccuranceFromLeft >= firstOccuranceFromRight) continue;

            // Creating a set to keep track of the unique chars between the two same first and last characters;
            /*
                - This is because any 3 length palindrome will be of the type XYX, meaning that
                the first and last chars will be the same and the middle char can be anything and it
                will still be a palindrome.
                - Therefore by identify the pairs of chars which have some chars in between will consitute 
                towards a plaindromic subsequnece of length 3
            */
            unordered_set<char> uniqueChars;
            // cout << ch << " " << firstOccuranceFromLeft << " " << firstOccuranceFromRight << endl;
            for(int i = firstOccuranceFromLeft + 1; i < firstOccuranceFromRight; ++i){
                uniqueChars.insert(s[i]);
            }

            uniquePalindromicSubsequencesCount += uniqueChars.size();
        }

        return uniquePalindromicSubsequencesCount;
    }
};