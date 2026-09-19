class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;

        int i = 0, j = 0;
        double currentSum = 0;

        double maximumAverage = -1e9;

        while(j < n){
            if(j - i + 1 != k){
                currentSum += nums[j++]; 
                continue;
            }

            currentSum += nums[j++];

            maximumAverage = Math.max(maximumAverage, currentSum / (double)k);

            
            currentSum -= nums[i++];
        }

        // maximumAverage = Math.max(maximumAverage, currentSum / k);


        return maximumAverage;
    }
}