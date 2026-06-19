class Solution {
    public int largestAltitude(int[] gain) {
        int highestAltitude = 0;
        int sum = 0;
        for(int g : gain) {
            sum += g;
            highestAltitude = Math.max(highestAltitude, sum);
        }

        return highestAltitude;
    }
}