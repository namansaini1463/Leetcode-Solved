class Solution {
    public int minBishopMoves(int[] source, int[] target) {
        // check the parity
        int sourceParity = (source[0] + source[1]) % 2;
        int targetParity = (target[0] + target[1]) % 2;

        int[][] directions = {{1, 1}, {-1, 1}, {1, -1}, {-1, -1}};

        if(sourceParity == targetParity){
            for(int[] direction : directions){
                int di = direction[0];
                int dj = direction[1];

                int ni = source[0] + di, nj = source[1] + dj;

                while(ni <= 8 && ni >= 1 && nj <= 8 && nj >= 1){
                    if(ni == target[0] && nj == target[1]) return 1;

                    ni += di;
                    nj += dj;
                }

                
            }

            return 2;

        }

        return -1;
    }
}