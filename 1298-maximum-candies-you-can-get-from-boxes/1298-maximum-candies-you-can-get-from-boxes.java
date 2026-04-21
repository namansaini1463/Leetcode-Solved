class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int n = status.length;

        boolean[] isOpened = new boolean[n];
        boolean[] hasBox = new boolean[n];
        boolean[] hasKey = new boolean[n];

        Deque<Integer> q = new ArrayDeque<>();

        for(int initialBox : initialBoxes){
            hasBox[initialBox] = true;

            if(status[initialBox] == 1){
                isOpened[initialBox] = true;
                q.offer(initialBox);
            } 
        }

        int candiesCollected = 0;

        while(!q.isEmpty()){
            int box = q.poll();

            candiesCollected += candies[box];

            for(int key : keys[box]){
                hasKey[key] = true;

                if(hasKey[key] && hasBox[key] && !isOpened[key]){
                    isOpened[key] = true;
                    q.offer(key);
                }
            }

            for(int containedBox : containedBoxes[box]){
                hasBox[containedBox] = true;

                if((status[containedBox] == 1 && !isOpened[containedBox]) || (hasKey[containedBox] && !isOpened[containedBox])){
                    isOpened[containedBox] = true;
                    q.offer(containedBox);
                }
            }

        }

        return candiesCollected;
    }
}