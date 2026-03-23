class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordListSet = new HashSet<>(wordList);

        if(!wordListSet.contains(endWord)) return 0;

        int transformationLength = 1;

        Set<String> visited = new HashSet<>();

        Deque<String> q = new ArrayDeque<>();
        q.offer(beginWord);
        visited.add(beginWord);

        while(!q.isEmpty()){
            int size = q.size();

            // System.out.println(q);

            while(size-- > 0){
                String current = q.poll();

                if(endWord.equals(current)) return transformationLength;

                char[] currentArray = current.toCharArray();
                for(int i = 0; i < currentArray.length; i++){
                    char currentChar = currentArray[i];

                    for(char ch : "abcdefghijklmnopqrstuvwxyz".toCharArray()){
                        currentArray[i] = ch;   

                        String newString = new String(currentArray);

                        if(!visited.contains(newString) && wordListSet.contains(newString)){
                            visited.add(newString);
                            q.add(newString);
                        }
                    }

                   currentArray[i] = currentChar;
                }
            }
            transformationLength++;
        }

        return 0;
    }
}