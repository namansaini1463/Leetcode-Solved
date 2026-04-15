class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        List<List<Integer>> rowAdj = new ArrayList<>();
        for(int i = 0; i < k; i++){
            rowAdj.add(new ArrayList<>());
        }

        int[] rowIndegree = new int[k];

        for(int[] rowCondition : rowConditions){
            int u = rowCondition[0] - 1, v = rowCondition[1] - 1;

            rowAdj.get(u).add(v);
            rowIndegree[v]++;
        }

        List<Integer> rowTopoSort = new ArrayList<>();

        Deque<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < k; i++){
           if(rowIndegree[i] == 0) q.offer(i);
        }

        while(!q.isEmpty()){
            int front = q.poll();
            rowTopoSort.add(front + 1);

            for(int adjNode : rowAdj.get(front)){
                rowIndegree[adjNode]--;

                if(rowIndegree[adjNode] == 0){
                    q.offer(adjNode);
                }
            }
        }

        if(rowTopoSort.size() != k) return new int[0][0];

        List<List<Integer>> colAdj = new ArrayList<>();
        for(int i = 0; i < k; i++){
            colAdj.add(new ArrayList<>());
        }

        int[] colIndegree = new int[k];

        for(int[] colCondition : colConditions){
            int u = colCondition[0] - 1, v = colCondition[1] - 1;

            colAdj.get(u).add(v);
            colIndegree[v]++;
        }

        List<Integer> colTopoSort = new ArrayList<>();

        Deque<Integer> qc = new ArrayDeque<>();
        for(int i = 0; i < k; i++){
           if(colIndegree[i] == 0) qc.offer(i);
        }

        while(!qc.isEmpty()){
            int front = qc.poll();
            colTopoSort.add(front + 1);

            for(int adjNode : colAdj.get(front)){
                colIndegree[adjNode]--;

                if(colIndegree[adjNode] == 0){
                    qc.offer(adjNode);
                }
            }
        }

        if(colTopoSort.size() != k) return new int[0][0];

        int[][] result = new int[k][k];

        for(int i = 1; i <= k; i++){
            int rowIndex = rowTopoSort.indexOf(i);
            int colIndex = colTopoSort.indexOf(i);

            result[rowIndex][colIndex] = i;
        }

        return result;
    }
}