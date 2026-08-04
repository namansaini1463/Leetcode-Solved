class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int n = nums.length;
        
        Set<Integer> set = new HashSet<>();
        for(int num : nums) set.add(num);

        Arrays.sort(nums);

        int smallest = nums[0];
        int largest = nums[n-1];

        List<Integer> result = new ArrayList<>();

        for(int i = smallest; i <= largest; i++){
            if(!set.contains(i)) result.add(i);
        }

        return result;
    }
}