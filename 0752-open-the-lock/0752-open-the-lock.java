class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> deadendSet = new HashSet<>(List.of(deadends));

        String start = "0000";

        if(deadendSet.contains(start)) return -1;
        if(target.equals(start)) return 0;

        Set<String> visited = new HashSet<>();

        Deque<String> q = new ArrayDeque<>();
        q.offer(start);
        visited.add(start);

        int moves = 0;

        while(!q.isEmpty()){
            int size = q.size();

            while(size-- > 0){
                String current = q.pop();

                if(target.equals(current)) return moves;

                if(deadendSet.contains(current)) continue;

                char[] currentArray = current.toCharArray();
                for(int i = 0; i < currentArray.length; i++){
                    char currentChar = currentArray[i];

                    //inrement with wrap-around
                    currentArray[i] = (char)(((((int)(currentChar - '0') + 1 + 10 ) % 10)) + '0');
                    String incrementString = new String(currentArray);
                
                    if(!visited.contains(incrementString)){
                        q.offer(incrementString);
                        visited.add(incrementString);
                    }
            
                    //decrement with wrap-around
                    currentArray[i] = (char)(((((int)(currentChar - '0') - 1 + 10) % 10)) + '0');

                    String decrementString = new String(currentArray);
                
                    if(!visited.contains(decrementString)){
                        q.offer(decrementString);
                        visited.add(decrementString);
                    }

                    currentArray[i] = currentChar;
                }
            }
            moves++;
        }

        return -1;
    }
}