class Solution {
    public int numOfSubarrays(int[] arr) {
        int prefixSum = 0;

        int evenPrefixSum = 1, oddPrefixSum = 0;

        int result = 0;

        for(int num : arr){
            prefixSum += num;

            if((prefixSum & 1) == 1){
                result += evenPrefixSum;
                oddPrefixSum++;
            } else {
                result += oddPrefixSum;
                evenPrefixSum++;
            }

            result = result % (int)(1e9 + 7);
        }

        return result;
    }
}