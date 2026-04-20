class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int max = 0;

        // Fix left = 0, scan from right
        for (int j = n - 1; j > 0; j--) {
            if (colors[0] != colors[j]) {
                max = Math.max(max, j - 0); 
                break; 
            }
        }

        // Fix right = n-1, scan from left
        for (int i = 0; i < n - 1; i++) {
            if (colors[i] != colors[n - 1]) {
                max = Math.max(max, (n - 1) - i);
                break; // leftmost valid i from right
            }
        }

        return max;
    }
}