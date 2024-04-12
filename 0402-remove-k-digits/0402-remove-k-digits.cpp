class Solution {
public:
    string removeKdigits(string num, int k) {
        string result = ""; //It will act as the result as well as the monotonic stack
        
        if(num.size() == k) return "0";
        
        result.push_back(num[0]);
        
        for(int i = 1; i < num.size(); i++){
            while(result.size() > 0 and result.back() > num[i] and k) {
                result.pop_back();
                k--;
            } 
            
            result.push_back(num[i]);
        }

        while(result.size() > 0 and k--){
            result.pop_back();
        }

        int i = 0;
        while(result[i] == '0' and i != result.size() - 1){
            result = result.substr(1, result.size());
        }

        
        return result;
    }
};