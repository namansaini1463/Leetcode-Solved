class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long k = (long)k1 + (long)k2;

        long[] frequencyDifference = new long[100_001];

        for(int i = 0; i < n; i++){
            int difference = Math.abs(nums1[i] - nums2[i]);
            frequencyDifference[difference]++;
        }

        for(int idx = 100_000; idx >= 0; idx--){
            if(frequencyDifference[idx] > 0){
                long usedFrequency = frequencyDifference[idx] - k;
                if(idx > 0){
                    if(usedFrequency < 0){
                        frequencyDifference[idx - 1] += frequencyDifference[idx];
                        k -= frequencyDifference[idx];
                        frequencyDifference[idx] = 0;
                    } else {
                        frequencyDifference[idx - 1] += k;
                        frequencyDifference[idx] = usedFrequency;
                        k = 0;
                    }
                }  
            }
        }

        long result = 0;
        for(int i = 0; i <= 100_000; i++){
            result += frequencyDifference[i] * i * i;
        }

        System.out.println(Arrays.toString(frequencyDifference));

        return result;


    }
}