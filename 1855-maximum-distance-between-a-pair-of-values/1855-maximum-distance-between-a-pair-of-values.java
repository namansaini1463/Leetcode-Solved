class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        int result = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums2[j] >= nums1[i]) {
                result = Math.max(result, j - i);
                j++;                  // valid pair, try extending j
            } else {
                i++;                  // nums1[i] too large, move i
                if (j < i) j = i;    // j must always be >= i
            }
        }

        return result;
    }
}