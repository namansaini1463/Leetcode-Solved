class Solution {
    public int minSwaps(int[] nums) {
        List<int[]> sumAndNum = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            int temp = n;
            int digitSum = 0;

            while (temp != 0) {
                digitSum += temp % 10;
                temp /= 10;
            }

            sumAndNum.add(new int[]{digitSum, n, i});
        }

        sumAndNum.sort((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        int swaps = 0;
        boolean[] visited = new boolean[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || sumAndNum.get(i)[2] == i) continue;

            int j = i;
            int cycleLength = 0;

            while (!visited[j]) {
                visited[j] = true;
                j = sumAndNum.get(j)[2];
                cycleLength++;
            }

            swaps += cycleLength - 1;
        }

        return swaps;
    }
}