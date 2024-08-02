class DisjointSet{
public:
    vector<int> parent, rank;

    DisjointSet(int n){
        parent.resize(n+1);
        for(int i = 0; i < parent.size(); i++){
            parent[i] = i;
        }

        rank.resize(n+1, 0);
    }

    int find(int u){
        if(parent[u] == u) return u;

        return parent[u] = find(parent[u]);
    }

    bool unionUV(int u, int v){
        int rootU = find(u);
        int rootV = find(v);

        if(rootU == rootV) return false;

        if(rank[rootU] < rank[rootV]){
            parent[rootU] = rootV;
        } else if(rank[rootV] < rank[rootU]){
            parent[rootV] = rootU;
        } else {
            parent[rootV] = rootU;
            rank[rootU]++;
        }

        return true;
    }
};

class Solution {
public:
    vector<vector<string>> accountsMerge(vector<vector<string>>& accounts) {
        unordered_map<string, int> mappingMailNamenum;
        int n = accounts.size();
        DisjointSet s1(n);

        for(int name = 0; name < accounts.size(); name++){
            for(int i = 1; i < accounts[name].size(); i++){
                if(mappingMailNamenum.find(accounts[name][i]) == mappingMailNamenum.end()){
                    mappingMailNamenum[accounts[name][i]] = name;
                } else {
                    s1.unionUV(mappingMailNamenum[accounts[name][i]], name);
                }
            } 
        }

        vector<vector<string>> mergedMails(n);
        for(const auto &it : mappingMailNamenum){
            string mail = it.first;
            int node = s1.find(it.second);

            mergedMails[node].push_back(mail);
        }

        for(auto &mergedMail : mergedMails){
            sort(mergedMail.begin(), mergedMail.end());
        }

        vector<vector<string>> result;
        for(int i = 0; i < n; i++){
            vector<string> temp;
            if(mergedMails[i].size()){
                temp.push_back(accounts[i][0]);
                for(const auto &mail : mergedMails[i]){
                    temp.push_back(mail);
                }
                result.push_back(temp);
            }
        }

        return result;
    }
};