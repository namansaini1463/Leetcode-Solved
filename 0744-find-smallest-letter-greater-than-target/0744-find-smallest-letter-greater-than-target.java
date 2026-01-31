class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        // Arrays.sort(letters);
        int l = 0, r = letters.length - 1;
        char ngl = letters[0];

        while(l <= r){
            int mid = l + (r-l)/2;

            if(letters[mid] > target){
                ngl = letters[mid];
                r = mid - 1;
            } else {
                l = mid + 1;
            }

        }

        // System.out.println(l + " " + r);
        // System.out.println(Arrays.toString(letters));
        return ngl;
    }
}