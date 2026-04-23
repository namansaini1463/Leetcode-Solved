class Solution {
    int[] nums;
    int n;
    long[][] dp;

    public long maxAlternatingSum(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        this.dp = new long[n+1][2];

        // Base case { if(idx >= n) return dp[idx][isEvenIndex] = 0; }
        dp[n][0] = 0; dp[n][1] = 0;
        for(int idx = n-1; idx >= 0; idx--){
            for(int isEvenIndex = 0; isEvenIndex < 2; isEvenIndex++){

                long pick = 0;
                if(isEvenIndex == 1){
                    pick = nums[idx] + dp[idx+1][0];
                } else {
                    pick = -1 * nums[idx] + dp[idx+1][1];
                }

                long skip = 0 + dp[idx+1][isEvenIndex];

                dp[idx][isEvenIndex] = Math.max(pick, skip);
            }
        }

        return dp[0][1];
    }
}

/*
class Solution {
    int[] nums;
    int n;
    long[][] dp;
    
    private long f(int idx, int isEvenIndex){
        if(idx >= n) return dp[idx][isEvenIndex] = 0;

        if(dp[idx][isEvenIndex] != -1) return dp[idx][isEvenIndex];

        long pick = 0;
        if(isEvenIndex == 1){
            pick = nums[idx] + f(idx+1, 0);
        } else {
            pick = -1 * nums[idx] + f(idx+1, 1);
        }

        long skip = 0 + f(idx + 1, isEvenIndex);

        return dp[idx][isEvenIndex] = Math.max(pick, skip);
    }

    public long maxAlternatingSum(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        this.dp = new long[n+1][2];

        for(int i = 0; i <= n; i++){
            Arrays.fill(dp[i], -1);
        }

        return f(0, 1); // 1 -> isEvenIndex = true
    }
}
*/