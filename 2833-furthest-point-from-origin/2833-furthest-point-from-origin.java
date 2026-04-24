class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int underscores = 0;
        int distance = 0;
        for(char ch : moves.toCharArray()){
            if(ch == 'L') distance--;
            else if(ch == 'R') distance++;
            else underscores++;
        }

        return Math.abs(distance) + underscores;
    }
}