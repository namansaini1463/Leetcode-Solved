class Solution {
    public String rearrangeString(String s, char x, char y) {
        Map<Character, Integer> map = new HashMap<>();

        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();

        int yFreq = map.getOrDefault(y, 0);
        while(yFreq-- > 0){
            sb.append(y);
        }
        map.remove(y);

        for(Map.Entry<Character, Integer> e : map.entrySet()){
            int f = e.getValue();
            while(f-- > 0){
                sb.append(e.getKey());
            }
        }

        return sb.toString();
    }
}