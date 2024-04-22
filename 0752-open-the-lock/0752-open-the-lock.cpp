class Solution {
public:
    int openLock(vector<string>& deadends, string target) {
        unordered_set<string> visited;
        for(const auto &deadend : deadends){
            visited.insert(deadend);
        }

        string start = "0000";

        if(visited.find(start) != visited.end()) return -1;
        
        int moves = 0;
        queue<string> q;
        q.push(start);

        while(!q.empty()){
            int n = q.size();

            while(n--){
                string current = q.front(); q.pop();
                if(current == target) return moves;

                for(int i = 0; i < 4; i++){
                    char ch = current[i];

                    char increment = ch == '9' ? '0' : ch + 1;
                    char decrement = ch == '0' ? '9' : ch - 1;

                    current[i] = increment;
                    if(visited.find(current) == visited.end()){
                        visited.insert(current);
                        q.push(current);
                    }

                    current[i] = decrement;
                    if(visited.find(current) == visited.end()){
                        visited.insert(current);
                        q.push(current);
                    }

                    current[i] = ch;
                } 
            }
            moves++;
        }

        return -1;
    }
};