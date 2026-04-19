class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        Set<String> visited = new HashSet<>();

        Deque<String> q = new ArrayDeque<>();
        q.offer(s);
        visited.add(s);

        String minimumString = s;

        while(!q.isEmpty()){
            String front = q.poll();
            int fl = front.length();

            if(front.compareTo(minimumString) < 0){
                minimumString = front;
            }

            StringBuilder transformed = new StringBuilder(front);

            // transform all the odd indices
            for(int i = 1; i < fl; i += 2){
               char newChar = (char)(((transformed.charAt(i) - '0' + a) % 10) + '0');
                transformed.setCharAt(i, newChar);
            }
            if(!visited.contains(transformed.toString())){
                q.offer(transformed.toString());
                visited.add(transformed.toString());
            }

            StringBuilder rotated = new StringBuilder();
            // rotate from index b
            for(int i = 0; i < fl; i++){
                rotated.append(front.charAt((i - b + fl) % fl));
            }

            if(!visited.contains(rotated.toString())){
                q.offer(rotated.toString());
                visited.add(rotated.toString());
            }

            // System.out.println(transformed);
            // System.out.println(rotated);
        }

        return minimumString;
    }
}