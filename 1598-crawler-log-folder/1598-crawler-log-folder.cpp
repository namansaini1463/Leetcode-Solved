class Solution {
public:
    int minOperations(vector<string>& logs) {
        int currentIndex = 0;
        
        for(int i = 0; i < logs.size(); i++){
            if(logs[i] != "../" and logs[i] != "./"){
                currentIndex++;
            }
            
            if(logs[i] == "../"){
                if(currentIndex > 0){
                    currentIndex--;
                }
            }
        }
               
        return currentIndex;
        
    }
};