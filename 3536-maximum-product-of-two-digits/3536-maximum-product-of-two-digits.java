class Solution {
    public int maxProduct(int n) {
        int largestDigit = -1;
        int secondLargestDigit = -1;

        while(n > 0){
            int digit = n % 10;
            n = n / 10;

            if(digit > largestDigit){
                secondLargestDigit = largestDigit;
                largestDigit = digit;
            } else if(digit > secondLargestDigit && digit <= largestDigit){
                secondLargestDigit = digit;
            }
        }

        return largestDigit * secondLargestDigit;
    }
}