class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankSet = new HashSet<>(List.of(bank));

        // Check if the end gene is a part of the bank
        if(!bankSet.contains(endGene)) return -1;

        char[] mutations = {'A', 'G', 'T', 'C'};

        Set<String> visited = new HashSet<>();
        Deque<String> q = new ArrayDeque<>();
        q.offer(startGene);
        visited.add(startGene);

        int mutationsCount = 0;

        while(!q.isEmpty()){
            int size = q.size();

            // System.out.println(q);

            while(size-- >0){
                String current = q.poll();

                System.out.println(current);
                if(endGene.equals(current)) return mutationsCount;

                char[] currentArray = current.toCharArray();
                
                for(int i = 0; i < currentArray.length; i++){
                    char currentChar = currentArray[i];

                    // System.out.println("All mutated strings for index: " + i);
                    for(char mutation : mutations){
                        currentArray[i] = mutation;

                        String mutatedString = new String(currentArray);
                        
                        if(!visited.contains(mutatedString)){
                            if(bankSet.contains(mutatedString)){
                                visited.add(mutatedString);
                                q.offer(mutatedString);
                            }
                        }
                    }

                    currentArray[i] = currentChar;
                }
            }
            mutationsCount++;
        }

        // System.out.println(bankSet);

        return -1;
    }
}