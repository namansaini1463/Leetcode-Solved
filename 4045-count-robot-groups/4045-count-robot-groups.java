class Solution {
    public int countGroups(int[] position, int[] speed, int distance) {
        int n = position.length;

        // Merge the possible robots initially
        for(int i = 0; i < n - 1; i++){
            if(position[i+1] - position[i] <= distance){
                position[i] = -1;
                speed[i] = -1;
            }
        }

        // Stack<Integer> stack = new Stack<>();

        int minimumSpeed = Integer.MAX_VALUE;
        int groups = 0;

        for(int i = n-1; i >= 0; i--){
            if(speed[i] == -1) continue;

            if(speed[i] <= minimumSpeed){
                minimumSpeed = speed[i];
                groups++;
            }

            // if(stack.isEmpty()) {
            //     stack.push(speed[i]);
            //     continue;
            // }

            // if(speed[i] <= stack.peek()) stack.push(speed[i]);
        }

        // System.out.println(Arrays.toString(position));
        // System.out.println(Arrays.toString(speed));

        return groups;
    }
}