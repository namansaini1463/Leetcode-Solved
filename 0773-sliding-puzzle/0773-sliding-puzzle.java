class Solution {
    public int slidingPuzzle(int[][] board) {
        int n = 2;
        int m = 3;

        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        StringBuilder initialConfiguration = new StringBuilder();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                initialConfiguration.append((char)(board[i][j] + '0'));
            }
        }

        Set<String> visited = new HashSet<>();

        Deque<String> q = new ArrayDeque<>();
        q.offer(initialConfiguration.toString());
        visited.add(initialConfiguration.toString());

        int moves = 0;

        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){    
                String front = q.poll();

                if(front.equals("123450")) return moves;

                int[][] reconstructedBoard = new int[n][m];
                int row = -1, col = -1;
                for(int i = 0; i < 6; i++){
                    int r = i / 3, c = i % 3;
                    reconstructedBoard[r][c] = front.charAt(i) - '0';

                    if(front.charAt(i) == '0'){
                        row = r; col = c;
                    }
                }

                for(int[] dir : directions){
                    int nr = row + dir[0];
                    int nc = col + dir[1];

                    if(nr >= 0 && nr < n && nc >= 0 && nc < m){
                        reconstructedBoard[row][col] = reconstructedBoard[nr][nc];
                        reconstructedBoard[nr][nc] = 0;

                        // System.out.println(Arrays.deepToString(reconstructedBoard));

                        StringBuilder changedConfiguration = new StringBuilder();
                        for(int i = 0; i < n; i++){
                            for(int j = 0; j < m; j++){
                                changedConfiguration.append((char)(reconstructedBoard[i][j] + '0'));
                            }
                        }

                        // System.out.println(changedConfiguration);

                        if(!visited.contains(changedConfiguration.toString())){
                            q.offer(changedConfiguration.toString());
                            visited.add(changedConfiguration.toString());
                        }

                        reconstructedBoard[nr][nc] = reconstructedBoard[row][col];
                        reconstructedBoard[row][col] = 0;
                    }
                }

                // System.out.println(Arrays.deepToString(reconstructedBoard));

            }

            moves++;

        }

        //System.out.println(initialConfiguration);

        return -1;
    }
}