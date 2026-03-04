class Solution {

    private String getNthString(int n){
        StringBuilder s = new StringBuilder("0");

        while(n-- != 1){
            StringBuilder inverted = invertBinaryString(s);
            s = s.append('1').append(inverted.reverse());
        }

        return s.toString();
    }
    private StringBuilder invertBinaryString(StringBuilder s){
        int len = s.length();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < len; i++){
            if(s.charAt(i) == '1'){
                sb.append('0');
            } else {
                sb.append('1');
            }
        }

        return sb;
    }

    public char findKthBit(int n, int k) {
        String finalString = getNthString(n);

        System.out.println(finalString);

        return finalString.charAt(k - 1);
    }
}