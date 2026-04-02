class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int startingNode = 0;

        Map<String, Integer> map = new HashMap<>();
        for(List<String> equation : equations){
            for(String e : equation){
                if(!map.containsKey(e)){
                    map.put(e, startingNode++);
                }
            }
        }

        int n = map.size();

        List<List<double[]>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }


        for(int i = 0; i < equations.size(); i++){
            int numerator =     map.get(equations.get(i).get(0));
            int denominator = map.get(equations.get(i).get(1));
            double value = values[i];

            // System.out.println(numerator + " " + denominator + " " + value);
        
            adj.get(numerator).add(new double[]{denominator, value});
            adj.get(denominator).add(new double[]{numerator, 1 / value});
        }

        int queriesSize = queries.size();
        double[] result = new double[queriesSize];

        for(int i = 0; i < queries.size(); i++){
            String src = queries.get(i).get(0);
            String dest = queries.get(i).get(1);

            if(!map.containsKey(src) || !map.containsKey(dest)){
                result[i] = -1.0;
                continue;
            }

            int numerator = map.get(src);
            int denominator = map.get(dest);

            boolean[] visited = new boolean[n];
            result[i] = dfs(numerator, denominator, 1.0, visited, adj);
            
        }

        // System.out.println(map);

        return result;
    }

    private double dfs(int node, int dst, double product, boolean[] visited, List<List<double[]>> adj) {
        visited[node] = true;

        if (node == dst)
            return product;

        for (double[] adjNodeArr : adj.get(node)) {
            int adjNode = (int) adjNodeArr[0];
            double val = adjNodeArr[1];

            if (!visited[adjNode]) {
                visited[adjNode] = true;
                double dfsResult = dfs(adjNode, dst, product * val, visited, adj);

                if (dfsResult != -1)
                    return dfsResult;
            }
        }

        return -1;
    }
}