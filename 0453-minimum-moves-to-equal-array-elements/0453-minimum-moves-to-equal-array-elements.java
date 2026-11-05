class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;

        int smallest = nums[0];

        for(int i = 0 ; i < n; i++){
            smallest = Math.min(smallest, nums[i]);
        }

        int moves = 0;

        for(int i = 0; i < n; i++){
            moves += nums[i] - smallest;
        }

        return moves;
    }
}