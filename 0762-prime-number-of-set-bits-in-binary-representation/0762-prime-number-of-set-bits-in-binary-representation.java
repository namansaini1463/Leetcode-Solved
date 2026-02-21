class Solution {
    public int countPrimeSetBits(int left, int right) {
        Set<Integer> primes = Set.of(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31);

        int primeSetBitsCount = 0;

        for(int i = left; i <= right; i++){
            int num = i;
            int bitsCount = 0;
            
            while(num != 0){
                bitsCount += num&1;
                num = num >> 1;
            }

            if(primes.contains(bitsCount)) primeSetBitsCount++;
        }

        return primeSetBitsCount;
    }
}