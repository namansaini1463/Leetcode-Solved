class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;

        int maximumDistance = 0;

        for(int i = 0; i < n; i++){
            for(int j = n - 1; j > i; j--){
                if(colors[i] != colors[j]){
                    maximumDistance = Math.max(maximumDistance, j - i);
                }
            }
        }

        return maximumDistance;
    }
}