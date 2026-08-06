class Solution {
    private boolean check(int num, int t) {
        int product = 1;

        while (num > 0) {
            product *= num % 10;
            num /= 10;
        }

        return product % t == 0;
    }

    public int smallestNumber(int n, int t) {
        while (!check(n, t)) {
            n++;
        }
        return n;
    }
}