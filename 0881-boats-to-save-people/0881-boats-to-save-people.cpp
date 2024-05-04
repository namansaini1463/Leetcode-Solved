class Solution {
public:
    int numRescueBoats(vector<int>& people, int limit) {
        sort(people.begin(), people.end());
        
        int left = 0, right = people.size() - 1;
        
        int boatsRequired = 0;
        while(left <= right){
            boatsRequired++;
            
            if(limit - people[right--] >= people[left]) left++;
            
        }
        
        return boatsRequired;
    }
};