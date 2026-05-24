class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;

        int drops = 0, dropIndex = -1;
        int rises = 0, riseIndex = -1;

        // 1. Count the breaks in the sequence, including the wrap-around to index 0
        for (int i = 0; i < n; i++) {
            int next = (i + 1) % n;
            
            if (nums[i] > nums[next]) {
                drops++;
                dropIndex = i;
            }
            if (nums[i] < nums[next]) {
                rises++;
                riseIndex = i;
            }
        }

        int minOps = Integer.MAX_VALUE;

        // 2. Is it a valid increasing cycle? (Exactly 1 drop)
        if (drops == 1) {
            if (dropIndex == n - 1) {
                // If the drop is at the very end, it's already perfectly sorted
                return 0; 
            } else {
                int l1 = dropIndex + 1; // Length of the first segment
                int l2 = n - l1;        // Length of the second segment
                minOps = Math.min(minOps, Math.min(l1, l2 + 2));
            }
        }

        // 3. Is it a valid decreasing cycle? (Exactly 1 rise)
        if (rises == 1) {
            int l1 = riseIndex + 1;
            int l2 = n - l1;
            minOps = Math.min(minOps, Math.min(l1 + 1, l2 + 1));
        }

        // 4. If it wasn't a valid cycle, minOps remains Integer.MAX_VALUE
        return minOps == Integer.MAX_VALUE ? -1 : minOps;
    }
}