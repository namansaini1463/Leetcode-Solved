class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> numsSet = new HashSet<>();

        for(int n : nums) numsSet.add(n);

        int i = 1, key = k;
        while(numsSet.contains(key)){
            key = k * i++;
        }

        return key;
    }
}