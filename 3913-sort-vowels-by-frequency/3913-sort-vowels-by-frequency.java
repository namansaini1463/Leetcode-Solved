class Solution {
    public String sortVowels(String s) {
        Map<Character, Integer> occurenceMap = new HashMap<>();
        Map<Character, Integer> frequencyMap = new HashMap<>();

        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));


        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(vowels.contains(ch)){
                frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);

                occurenceMap.putIfAbsent(ch, i);
            }
        }

        List<Map.Entry<Character, Integer>> entries = new ArrayList<>(frequencyMap.entrySet());

        entries.sort((a, b) ->{ 
            if(!a.getValue().equals(b.getValue()))
                return b.getValue() - a.getValue();

            return occurenceMap.get(a.getKey()) -  occurenceMap.get(b.getKey());
        });

        int idx = 0, count = 0;
        StringBuilder sb = new StringBuilder(s);
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(vowels.contains(ch)){
                sb.setCharAt(i, entries.get(idx).getKey()); count++;
                if(count == entries.get(idx).getValue()){
                    idx++; count = 0;
                }
                
            }
        }

        return sb.toString();

    }
}