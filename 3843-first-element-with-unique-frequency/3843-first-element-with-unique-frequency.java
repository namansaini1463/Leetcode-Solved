class Solution {
    public int firstUniqueFreq(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> freqMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
        }

        Map<Integer, List<Integer>> map = new LinkedHashMap<>();

        // Iterate over the frequency map
        for (Map.Entry<Integer, Integer> e : freqMap.entrySet()) {
            map.computeIfAbsent(e.getValue(), k -> new ArrayList<>())
                .add(e.getKey());
        }

        // Iterate over the map list
        for(List<Integer> list : map.values()){
            if(list.size() == 1) return list.get(0); // If the size of the list is 1, return the element at index 0
        }

        // System.out.println(map);

        return -1;
    }
}