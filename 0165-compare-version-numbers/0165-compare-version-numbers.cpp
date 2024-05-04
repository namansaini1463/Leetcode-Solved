class Solution {
public:
    int compareVersion(string version1, string version2) {
        stringstream v1(version1);
        stringstream v2(version2);

        // Tokenize the input string by . delimiter 
        string token; 
        vector<int> subversions1; 
        vector<int> subversions2; 
        char delimiter = '.'; 
    
        while (getline(v1, token, delimiter)) { 
            subversions1.push_back(stoi(token)); 
        } 
        while (getline(v2, token, delimiter)) { 
            subversions2.push_back(stoi(token)); 
        } 

        while(subversions1.size() > subversions2.size()){
           subversions2.push_back(0); 
        }

        while(subversions2.size() > subversions1.size()){
           subversions1.push_back(0); 
        }


        for(int i = 0; i < subversions1.size(); i++){
            if(subversions1[i] > subversions2[i]) return 1;
            if(subversions1[i] < subversions2[i]) return -1;
        }
    
        return 0; 
    }
};