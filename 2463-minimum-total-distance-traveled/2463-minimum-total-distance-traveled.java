class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {

        Collections.sort(robot);
        Arrays.sort(factory, Comparator.comparingInt(a -> a[0]));

        List<Integer> factories = new ArrayList<>();

        for (int[] f : factory) {
            int count = f[1];
            while (count-- > 0) {
                factories.add(f[0]);
            }
        }

        int r = robot.size();
        int f = factories.size();

        long[][] dp = new long[r + 1][f + 1];

        // base case
        for (int i = 0; i < r; i++) {
            dp[i][f] = Long.MAX_VALUE;
        }

        for (int i = r - 1; i >= 0; i--) {
            for (int j = f - 1; j >= 0; j--) {

                long take =  Long.MAX_VALUE;
                if(dp[i + 1][j+1] < Long.MAX_VALUE){
                    take = Math.abs(robot.get(i) - factories.get(j)) + dp[i + 1][j + 1];
                }

                long skip = dp[i][j + 1];

                dp[i][j] = Math.min(take, skip);
            }
        }

        return dp[0][0];
    }
}