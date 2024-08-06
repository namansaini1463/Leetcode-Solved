class Solution {
public:
    static bool comparator(pair<int, int> &p1, pair<int, int> &p2){
        if(p1.first != p2.first){
            return p1.first > p2.first;
        } 
        return p1.second > p2.second;
    }
public:
    int minimumPushes(string word) {
        vector<pair<int, int>> freq(26);
        for(int i = 0; i < 26; i++){
            freq[i] = {0, i};
        }

        for(int i = 0; i < word.size(); i++){
            freq[word[i] - 'a'].first++;
        }

        sort(freq.begin(), freq.end(), comparator);

        //for(int i = 0; i < 25; i++){
        //    cout << freq[i].first << " " << freq[i].second << endl;
        //}

        int minimumPushes = 0;
        for(int i = 0; i < 26; i++){
            if(i <= 7){
                minimumPushes += freq[i].first * 1;
            } else if( i<= 15){
                minimumPushes += freq[i].first * 2;
            } else if(i <= 23){
                minimumPushes += freq[i].first * 3;
            } else {
                minimumPushes += freq[i].first * 4;
            }
        }

        return minimumPushes;
    }
};