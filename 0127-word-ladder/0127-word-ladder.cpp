class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        // creating a set of all the words in the wordList so the serching for a word can be done in constant time
        // Using a set also acts a way to mark a word as processed just by simply removing it from the set
        unordered_set<string> words(wordList.begin(), wordList.end());  

        //used in the BFS traversal
        queue<pair<string, int>> q; // {word, level}
        q.push({beginWord, 1});

        words.erase(beginWord); // removing beginWord from the set to mark it as processed

        while(!q.empty()){
            string word = q.front().first;
            int level = q.front().second;
            q.pop();

            if(word == endWord) return level;

            for(int i = 0; i < word.size(); i++){
                char originalChar = word[i];
                for(char ch = 'a'; ch <= 'z'; ch++){
                    word[i] = ch;

                    if(words.find(word) != words.end()){ //it means that the newly created word is present in the wordlist
                        q.push({word, level + 1});

                        words.erase(word);
                    }
                }   
                word[i] = originalChar;
            }
        }

        return 0;

    }
};