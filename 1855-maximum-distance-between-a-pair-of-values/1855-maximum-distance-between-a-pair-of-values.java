class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int result = 0;

        for(int i = 0; i < n1; i++){
            // Binary search for best j
            int j = -1;
            int low = i, high = n2-1;

            while(low <= high){
                int mid = low + (high - low) / 2;

                if(nums2[mid] >= nums1[i]){
                    j = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            if(j != -1){
                // System.out.printf("i, j = %d, %d \n", i, j);
                result = Math.max(result, j - i);
            }

        }


        return result;
    }
}