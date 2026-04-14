class Solution {
    List<Integer> robots;
    List<Integer> factories;
    long[][] dp;

    private long findMinimumDistance(int i, int j) {

        if (i >= this.robots.size())
            return 0;
        if (j >= this.factories.size())
            return Long.MAX_VALUE;

        if (dp[i][j] != -1)
            return dp[i][j];

        long takeNext = findMinimumDistance(i + 1, j + 1);

        long takeCurrentFactory = Long.MAX_VALUE;

        if (takeNext != Long.MAX_VALUE) {
            takeCurrentFactory = Math.abs(this.robots.get(i) - this.factories.get(j)) + takeNext;
        }
        long skipCurrentFactory = 0 + findMinimumDistance(i, j + 1);

        return dp[i][j] = Math.min(takeCurrentFactory, skipCurrentFactory);
    }

    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, Comparator.comparingInt(a -> a[0]));

        // Expand the factory array to a 1d array 
        List<Integer> factories = new ArrayList<>();
        for (int[] f : factory) {
            int count = f[1];
            while (count-- > 0) {
                factories.add(f[0]);
            }
        }

        this.robots = robot;
        this.factories = factories;

        this.dp = new long[robots.size()][factories.size()];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        int i = 0, j = 0;

        long minimumDistance = findMinimumDistance(i, j);

        // System.out.println(robot);
        // System.out.println(factories);
        // System.out.println(Arrays.deepToString(factory));

        return minimumDistance;
    }
}