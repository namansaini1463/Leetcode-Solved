class Solution {
    public int minimumDifference(int[] nums, int k) {
        int n = nums.length;

        if(k == 1) return 0;
        Arrays.sort(nums);

        System.out.println(Arrays.toString(nums));

        int minDifference = Integer.MAX_VALUE;
        for(int i = 0; i < n - k + 1; i++){
            int currentDifference = nums[i + k - 1] - nums[i];
            minDifference = Math.min(minDifference, currentDifference);
        }


        return minDifference;

        // if(k == 1) return 0;

        // int maximumScore = Integer.MIN_VALUE, nextMaximumScore = Integer.MIN_VALUE;

        // for(int score : nums){
        //     if(score > maximumScore){
        //         nextMaximumScore = maximumScore;
        //         maximumScore = score;
        //     } else if(score > nextMaximumScore && score < maximumScore){
        //         nextMaximumScore = score;
        //     }
        // }
    
        // return maximumScore - nextMaximumScore;
    }
}