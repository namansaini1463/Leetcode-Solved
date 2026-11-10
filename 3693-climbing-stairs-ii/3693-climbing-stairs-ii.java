class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n+1];

        dp[0] = 0;

        for(int i = 1; i <= n; i++){
            int minimumCost = Integer.MAX_VALUE;
            
            for(int idx = 1; idx <= 3; idx++){
                if(i - idx >= 0) minimumCost = Math.min(minimumCost, dp[i - idx] + costs[i-1] + idx * idx);    
            }

            dp[i] = minimumCost;
        }

        // System.out.println(Arrays.toString(dp));

        return dp[n];
    }
}