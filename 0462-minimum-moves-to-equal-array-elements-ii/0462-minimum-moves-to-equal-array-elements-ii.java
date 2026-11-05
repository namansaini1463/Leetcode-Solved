class Solution {
    public int minMoves2(int[] nums) {
        int n = nums.length;

        int mid = n/2;
        Arrays.sort(nums);

        int moves = 0;

        for(int i = 0; i < n; i++){
            moves += Math.abs(nums[i] - nums[mid]);
        }

        return moves;
    }
}