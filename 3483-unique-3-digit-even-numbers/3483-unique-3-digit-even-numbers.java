class Solution {
    private void solve(int number, int[] digits, boolean[] digitsUsed, Set<Integer> numbers){
        if(number >= 100 && number < 1000){
            if(number % 2 == 0) numbers.add(number);

            return;
        }

        for(int i = 0; i < digits.length; i++){
            if(digitsUsed[i]) continue;

            if(number == 0 && digits[i] == 0) continue;

            digitsUsed[i] = true;

            solve(number * 10 + digits[i], digits, digitsUsed, numbers);

            digitsUsed[i] = false;
        }
    }

    public int totalNumbers(int[] digits) {
        boolean[] digitsUsed = new boolean[10];

        Set<Integer> numbers = new HashSet<>(); 

        solve(0, digits, digitsUsed, numbers);

        return numbers.size();
    }
}