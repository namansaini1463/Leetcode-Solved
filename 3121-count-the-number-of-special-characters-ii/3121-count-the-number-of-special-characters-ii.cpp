class Solution {
public:
    int numberOfSpecialChars(string word) {
        int capitals[26]; // The index will represent the aplhabet and the value in the array will represent the index of the first occurance
        int smalls[26];

        fill_n(capitals, 26, -1);
        fill_n(smalls, 26, -1);

        for(int i = 0; i < word.size(); i++){
            // cout << word[i] << endl;
            if(word[i] -'a' < 0) {
                if(capitals[word[i] - 'A'] == -1)
                    capitals[word[i] - 'A'] = i;
            }
            else smalls[word[i] - 'a'] = i;

            // for(int i = 0; i < 26; i++){
            // cout << smalls[i] << " " << capitals[i] << endl;
            // }

            // cout << endl << endl;

        }

        

        int count = 0;
        for(int i = 0; i < 26; i++){
            if(smalls[i] != -1 and capitals[i] != -1 and smalls[i] < capitals[i]) count++;
        }

        return count;

    }
};