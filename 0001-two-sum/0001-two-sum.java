class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>(); // value, index
        
        for(int i = 0; i < n; i++){
            if(map.containsKey(target - nums[i])){
                return new int[]{i, map.get(target - nums[i])};
            } else {
                map.put(nums[i], i);
            }
        }

        return new int[]{-1, - 1};
        
    }
}