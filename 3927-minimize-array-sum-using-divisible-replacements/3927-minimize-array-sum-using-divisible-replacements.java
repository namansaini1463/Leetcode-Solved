class Solution {
    public long minArraySum(int[] nums) {
        int n = nums.length;

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        long result = 0;

       for(int i = 0; i < n; i++){
            int number = nums[i];
            int divisor = number;

            for(int f = 1; (long)f*f <= number; f++){
                if(number % f == 0){
                    if(set.contains(f)){
                        divisor = Math.min(divisor, f);
                    } 
                    if(set.contains(number / f)){
                        divisor = Math.min(divisor, number / f);
                    }
                }
            }

            result += divisor;
        }

        return result;
    }
}