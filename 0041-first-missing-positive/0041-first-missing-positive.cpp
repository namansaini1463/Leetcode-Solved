class Solution {
public:
    int firstMissingPositive(vector<int>& nums) {
        int n = nums.size();
        bool contains1 = false;
        
        //? If the array does not include 1, then 1 is the only smallest positive number that is missing, therefore we return 1
        for(int i = 0; i < n; i++){
            if(nums[i] == 1) contains1 = true;
            
            //? Removing all the elements that are less than or equal to 0 and also those elements that are greater than the size of the array
            //? Because our answer of the missing number will always lie in the range [1, n] 
            //? Doing this also helps in the logic after this part, where we use negation to mark the number as visited
            if(nums[i] <= 0 or nums[i] > n) nums[i] = 1; 
        }
        if(!contains1) return 1;
        
        for(int i = 0; i < n; i++){
            int idx = abs(nums[i]) - 1;
            
            if(nums[idx] < 0) continue;
            else {
                nums[idx] = - nums[idx]; //? Negating the element to make it marked
            }
        }
        
        for(int i = 0; i < n; i++){
            if(nums[i] > 0) return i+1;
        }
        
        return n + 1;
            
    }
};