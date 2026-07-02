class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n = grid.size();
        int m = grid.get(0).size();

        int[][] directions = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};

        int[][] dist = new int[n][m];
        for(int i = 0; i < n; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{0, 0, grid.get(0).get(0)});
        dist[0][0] = grid.get(0).get(0);

        while(!pq.isEmpty()){
                int[] top = pq.poll();

                int r = top[0], c = top[1];
                int h = top[2];

                if(h >= health || h > dist[r][c]) continue;

                if(r == n-1 && c == m-1) return true;


                for(int[] direction : directions){
                    int nr = r + direction[0];
                    int nc = c + direction[1];

                    if(nr >= 0 && nr < n && nc >= 0 && nc < m){
                        int nh = h + grid.get(nr).get(nc);
                        if(dist[nr][nc] > nh){
                            dist[nr][nc] = nh;
                            pq.offer(new int[]{nr, nc, nh});
                        }
                    }
                }
        }

        return false;
    }
}