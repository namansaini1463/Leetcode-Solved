class Solution {
    boolean[][] isPalindrome;

    public void solve(String s, int idx, List<String> currentPartition, List<List<String>> allPartitions){
        int n = s.length();
        if(idx == n){
            allPartitions.add(new ArrayList<>(currentPartition));
            return;
        }

        for(int j = idx; j < n; j++){
            if(isPalindrome[idx][j]){
                currentPartition.add(s.substring(idx, j+1));
                solve(s, j+1, currentPartition, allPartitions);
                currentPartition.remove(currentPartition.size() - 1);
            }
        }


    }

    public List<List<String>> partition(String s) {
        int n = s.length();

        this.isPalindrome = new boolean[n][n];
        for(int i = 0; i < n; i++){
            isPalindrome[i][i] = true;
        }

        for(int L = 2; L <= n; L++){
            for(int i = 0; i + L - 1 < n; i++){
                int j = i + L - 1;

                if(s.charAt(i) == s.charAt(j)){
                    if(L == 2){
                        isPalindrome[i][j] = true;
                    } else {
                        isPalindrome[i][j] = isPalindrome[i+1][j-1];
                    }
                }
            }
        }

        List<List<String>> allPartitions = new ArrayList<>();
        List<String> currentPartition = new ArrayList<>();  

        solve(s, 0, currentPartition, allPartitions);
        
        // for(int i = 0; i < n; i++){
        //     System.out.println(Arrays.toString(isPalindrome[i]));
        // }

        return allPartitions;
    }
}