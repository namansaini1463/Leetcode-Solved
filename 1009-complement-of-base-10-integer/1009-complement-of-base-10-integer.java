class Solution {
    public int bitwiseComplement(int n) {
        String nBits = Integer.toBinaryString(n);

        // System.out.println(nBits);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < nBits.length(); i++){
            sb.append(nBits.charAt(i) == '0' ? "1" : "0");
        }

        int result = Integer.parseInt(sb.toString(), 2);

        return result;

    
    
    }

}