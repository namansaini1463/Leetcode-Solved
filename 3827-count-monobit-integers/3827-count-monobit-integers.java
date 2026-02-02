class Solution {
    private boolean isMonobit(int n){
        while(n > 0){
            int bit = n & 1;
            if(bit != 1) return false;

            n = n >> 1; 
        }

        return true;
    }
    
    public int countMonobit(int n) {
        int ans = 0;
        for(int i = 0; i <= n; i++){
            if(i == 0 || isMonobit(i)) ans++;
        }

        return ans;
    }
}