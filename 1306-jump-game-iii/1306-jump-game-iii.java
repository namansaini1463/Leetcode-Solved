class Solution {
    int[] arr;
    boolean[] visited;

    private boolean dfs(int idx){
        if(idx < 0 || idx >= arr.length) return false;
        if(visited[idx]) return false;
        if(arr[idx] == 0) return true;

        visited[idx] = true;

        // go left;
        boolean left = dfs(idx - arr[idx]);

        // go right
        boolean right = dfs(idx + arr[idx]);

        return left || right;
    }

    public boolean canReach(int[] arr, int start) {
        this.arr = arr;
        this.visited = new boolean[arr.length];

        return dfs(start);
    }
}