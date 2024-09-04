class Solution {
public:
    int getLucky(string s, int k) {
        int num = 0;
        for(auto ch : s){
            int idx = ch - 'a' + 1;
            while(idx > 0){
                num += idx % 10;
                idx /= 10; 
            }
        }
        k--;

        while(k--){
            int tempSum = 0;
            while(num > 0){
                tempSum += num % 10;
                num /= 10;
            }
            num = tempSum;

        }
        return num;
    }
};