class Solution {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size();

        int result = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                Set<Integer> set = new HashSet<>();

                for(int k = i; k <= j; k++){
                    set.add(nums.get(k));
                }


                int setsize = set.size();
                result += setsize * setsize;

                // System.out.println(set);
            }
        }

        return result;
    }
}