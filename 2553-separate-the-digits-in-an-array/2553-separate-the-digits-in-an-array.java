class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> separatedDigitsList = new ArrayList<>();
        for(int n : nums){
            String str = Integer.toString(n);
            for(char ch : str.toCharArray()){
                separatedDigitsList.add(((int)(ch - '0')));
            }
        }

        int[] separatedDigits = separatedDigitsList.stream().mapToInt(i -> i).toArray();

        // System.out.println(separatedDigitsList);

        return separatedDigits;
    }
}