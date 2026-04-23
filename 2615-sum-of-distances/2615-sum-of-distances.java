class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] result = new long[n];

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        for (List<Integer> indices : map.values()) {
            int m = indices.size();
            if (m == 1) continue;

            long[] prefix = new long[m + 1];
            for (int k = 0; k < m; k++) {
                prefix[k + 1] = prefix[k] + indices.get(k);
            }

            long total = prefix[m];

            for (int pos = 0; pos < m; pos++) {
                long i = indices.get(pos);
                long left = i * pos - prefix[pos];
                long right = (total - prefix[pos + 1]) - i * (m - 1 - pos);
                result[(int) i] = left + right;
            }
        }

        return result;
    }
}