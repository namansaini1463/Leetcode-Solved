class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        List<Integer> result = new ArrayList<>();

        // Process each query
        for(int i : queries){
            List<Integer> list = map.get(nums[i]);

            if(list.size() < 2) {
                result.add(-1); 
                continue;
            } else {
                int s = list.size();
                // System.out.println("list size" + s);
                // binary search the index of 'i' in list
                // System.out.println("processing: " + i);
                int l = 0, h = s - 1;
                int idx = 0;

                while(l <= h){
                    idx = l + (h-l)/2;

                    if(list.get(idx) == i) break;
                    else if(list.get(idx) > i){
                        h = idx - 1;
                    } else {
                        l = idx + 1;
                    }
                }

                int rightIdx = list.get((idx + 1) % s);
                int leftIdx = list.get((idx - 1 + s) % s);

                int distRight = Math.min(Math.abs(i - rightIdx), n - Math.abs(i - rightIdx));
                int distLeft = Math.min(Math.abs(i - leftIdx), n - Math.abs(i - leftIdx));

                result.add(Math.min(distRight, distLeft));
            }
        }

        // System.out.println(map);

        return result;
    }
}