class Solution {
    public int[] limitOccurrences(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> freq = new HashMap<>();
        
        for(int num : nums){
            if(freq.getOrDefault(num, 0) == k) continue;
            result.add(num);
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int[] resultArr = new int[result.size()];

        for(int i = 0; i < result.size(); i++){
            resultArr[i] = result.get(i);
        }

        return resultArr;
    }
}