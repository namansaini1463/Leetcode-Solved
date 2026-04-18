class Solution {
    private int reverse(int n){
        int reversed = 0;
        while(n > 0){
            int digit = n % 10;
            n = n / 10;

            reversed = reversed * 10 + digit;
        }

        return reversed;
    }
    public int mirrorDistance(int n) {
        return Math.abs(n - reverse(n));
    }
}