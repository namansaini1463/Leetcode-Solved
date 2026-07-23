class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;

        if(n == 1 || n == 2) return n;

        int bitsOfN = (int)(Math.log(n)/Math.log(2)) + 1;
        // System.out.println(bitsOfN);

        return 1 << bitsOfN;
    }
}