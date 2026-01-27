class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);

        int minimumDifference = arr[1] - arr[0];
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 1; i < n; i++){
            int currentDifference = arr[i] - arr[i-1];

            if(currentDifference < minimumDifference){
                result.clear();
                minimumDifference = currentDifference;
                result.add(List.of(arr[i-1], arr[i]));
            } else if(currentDifference == minimumDifference){
                result.add(List.of(arr[i-1], arr[i]));
            }
        }   

        return result;
    }
}