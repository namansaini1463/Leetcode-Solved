class Solution {
    List<String> board;
    int mod = 1_000_000_007;
    int[][] paths;
    int[][] scores;

    public int[] f(int i, int j) { // return {maxScore, numberOfPaths}
        if (i < 0 || j < 0) {
            return new int[] { -1, 0 };
        }
        if (board.get(i).charAt(j) == 'X') {
            paths[i][j] = 0;
            scores[i][j] = -1;
            return new int[] { -1, 0 };
        }

        if (i == 0 && j == 0) {
            paths[i][j] = 1;
            scores[i][j] = 0;
            return new int[] { 0, 1 };
        }

        if (paths[i][j] != -2 && scores[i][j] != -2)
            return new int[] { scores[i][j], paths[i][j] };

        int[] up = f(i - 1, j);
        int[] left = f(i, j - 1);
        int[] diag = f(i - 1, j - 1);

        int numberOfPaths = 0;
        int maxScore = Math.max(diag[0], Math.max(up[0], left[0]));
        if (maxScore == -1) {
            paths[i][j] = 0;
            scores[i][j] = -1;
            return new int[] { -1, 0 };
        }

        if (maxScore == up[0])
            numberOfPaths += up[1];
        if (maxScore == left[0])
            numberOfPaths += left[1];
        if (maxScore == diag[0])
            numberOfPaths += diag[1];

        char ch = board.get(i).charAt(j);
        if (ch != 'S' && ch != 'E') {
            maxScore += ch - '0';
        }

        paths[i][j] = numberOfPaths % mod;
        scores[i][j] = maxScore;
        return new int[] { maxScore, numberOfPaths % mod };

    }

    public int[] pathsWithMaxScore(List<String> board) {
        this.board = board;

        int n = board.size();

        this.paths = new int[n][n];
        this.scores = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(paths[i], -2);
            Arrays.fill(scores[i], -2);
        }

        int[] result = f(n - 1, n - 1);
        if (result[0] == -1)
            return new int[] { 0, 0 };

        return result;
    }
}