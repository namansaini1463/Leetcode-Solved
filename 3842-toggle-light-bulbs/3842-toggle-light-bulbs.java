class Solution {
    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        int n = bulbs.size();
        boolean[] toggleMap = new boolean[101];

        for(int i = 0; i < n; i++){
            toggleMap[bulbs.get(i)] = !toggleMap[bulbs.get(i)];
        }

        List<Integer> result = new ArrayList<>();
        for(int i = 1; i <= 100; i++){
            if(toggleMap[i]) result.add(i);
        }

        return result;
    }
}