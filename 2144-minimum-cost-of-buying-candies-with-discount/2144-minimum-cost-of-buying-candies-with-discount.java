class Solution {
    public int minimumCost(int[] cost) {
        int n = cost.length;

        Arrays.sort(cost);

        int minimumCost = 0; int counter = 1;

        for(int i = n-1; i >= 0; i--){
            if(counter == 3){
                counter = 1;
                continue;
            } else {
                minimumCost += cost[i];
                counter++;
            }
        }

        return minimumCost;
    }
}