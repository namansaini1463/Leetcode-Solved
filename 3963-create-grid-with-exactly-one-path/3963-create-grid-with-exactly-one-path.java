class Solution {
    public String[] createGrid(int m, int n) {
        String[] result = new String[m];

        for(int i = 0; i < m-1; i++){
            StringBuilder sb = new StringBuilder("#".repeat(n));

            sb.setCharAt(0, '.');

            result[i] = sb.toString();
        }

        result[m-1] = new StringBuilder(".".repeat(n)).toString();

        return result;
        
    }
}