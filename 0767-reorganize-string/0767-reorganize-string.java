class Solution {
    public String reorganizeString(String s) {
        int[] frequency = new int[26];
        for(char ch : s.toCharArray()){
            frequency[ch - 'a']++;
        }

        // System.out.println(Arrays.toString(frequency));

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        for(int i = 0; i < 26; i++){
            if(frequency[i] > 0) pq.offer(new int[]{frequency[i], i});
        }

        // System.out.println(pq);

        StringBuilder sb = new StringBuilder();
        while(pq.size() > 1){
            int[] max = pq.poll();
            int[] s_max = pq.poll();

            sb.append((char)(max[1] + 'a'));
            sb.append((char)(s_max[1] + 'a'));

            // System.out.println(sb);

            

            if(max[0] > 1) pq.offer(new int[]{max[0] - 1, max[1]});
            if(s_max[0] > 1) pq.offer(new int[]{s_max[0] - 1, s_max[1]});
        }

        if(pq.size() == 1 && pq.peek()[0] == 1){
            int[] last = pq.poll();
            sb.append((char)(last[1] + 'a'));
        } else if(pq.size() == 0){
            sb.toString();
        } else return "";

        return sb.toString();
    }

    // public class Pair{
    //     int frequency;
    //     Character character;
    // }
}