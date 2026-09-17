class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        
        // Stores the min length of a valid subarray ending at or before index j
        int[] minLenTill = new int[n]; 
        
        int currentSum = 0;
        int bestSoFar = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;
        
        int i = 0;
        
        for (int j = 0; j < n; j++) {
            currentSum += arr[j];
            
            // Shrink window if sum exceeds target
            while (currentSum > target && i <= j) {
                currentSum -= arr[i++];
            }
            
            if (currentSum == target) {
                int currentLength = j - i + 1;
                
                // If there's a valid subarray before our current window starts (i - 1)
                // we calculate the sum of their lengths
                if (i > 0 && minLenTill[i - 1] != Integer.MAX_VALUE) {
                    result = Math.min(result, currentLength + minLenTill[i - 1]);
                }
                
                bestSoFar = Math.min(bestSoFar, currentLength);
            }
            
            // Update the DP array for the current index
            minLenTill[j] = bestSoFar;
        }
        
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}