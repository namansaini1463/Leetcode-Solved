class Solution {
    public long sumAndMultiply(int n) {
        long x = 0;
        long digitSum = 0;

        String num = String.valueOf(n);
        for (char ch : num.toCharArray()) {
            int digit = ch - '0';
            if (digit > 0) {
                x = x * 10 + digit;
                digitSum += digit;
            }
        }

        return x * digitSum;
    }
}