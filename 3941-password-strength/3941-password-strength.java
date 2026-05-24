class Solution {
    public int passwordStrength(String password) {
        int strength = 0;

        Set<Character> symbols = new HashSet<>(Arrays.asList('!', '@', '#', '$'));
        // System.out.println(symbols); 
        Set<Character> seen = new HashSet<>();
        
        for(char ch : password.toCharArray()){
            if(seen.contains(ch)) continue;
            
            seen.add(ch);

            if(ch >= 'a' && ch <= 'z') strength += 1;
            else if(ch >= 'A' && ch <= 'Z') strength += 2;
            else if(ch >= '0' && ch <= '9') strength += 3;
            else if(symbols.contains(ch)) strength += 5;
        }

        return strength;
    }
}