class Solution {
    public List<Integer> findValidElements(int[] nums) {
        int n = nums.length;

        List<Integer> result = new ArrayList<>();

        List<Integer> maxSoFarLeft = new ArrayList<>();
        maxSoFarLeft.add(nums[0]);
        for(int i = 1; i < n; i++){
            if(maxSoFarLeft.getLast() < nums[i]) maxSoFarLeft.add(nums[i]);
            else maxSoFarLeft.add(maxSoFarLeft.getLast());
        }

        List<Integer> maxSoFarRight = new LinkedList<>();
        maxSoFarRight.addFirst(nums[n-1]);
        for(int i = n-2; i >= 0; i--){
            if(maxSoFarRight.getFirst() < nums[i]) maxSoFarRight.addFirst(nums[i]);
            else maxSoFarRight.addFirst(maxSoFarRight.getFirst());
        }

        for (int i = 0; i < n; i++) {
            boolean greaterThanLeft = (i == 0) || nums[i] > maxSoFarLeft.get(i - 1);
            boolean greaterThanRight = (i == n - 1) || nums[i] > maxSoFarRight.get(i + 1);
            if (greaterThanLeft || greaterThanRight) {
                result.add(nums[i]);
            }
        }

        return result;

    }
}