class Solution {
public:
    int maximumGain(string s, int x, int y) {
        string firstSubstring, secondSubstring;
        int firstMultiplier, secondMultiplier;
        
        int firstSubstringCount = 0;
        int secondSubstringCount = 0;
        
        //Greedily selecting the string which has the larger value to be processed first
        if(x > y){
            firstSubstring = "ab";
            secondSubstring = "ba";
            firstMultiplier = x;
            secondMultiplier = y;
        } else {
            firstSubstring = "ba";
            secondSubstring = "ab";
            firstMultiplier = y;
            secondMultiplier = x;
        }


        //Finding the number of occurances of the first substring and removing the substring from the string
        int i = 1;
        while(i < s.size()){
            if(i > 0 and s[i-1] == firstSubstring[0] and s[i] == firstSubstring[1]){
                firstSubstringCount++;
                s.erase(i-1, 2);
                i--;
                continue;
            }

            i++;
        }
        
        //Finding the number of occurances of the second substring and removing the substring from the string
        i = 1;
        while(i < s.size()){
            if(i > 0 and s[i-1] == secondSubstring[0] and s[i] == secondSubstring[1]){
                secondSubstringCount++;
                s.erase(i-1, 2);
                i--;
                continue;
            }

            i++;
        }


        return firstSubstringCount*firstMultiplier + secondSubstringCount*secondMultiplier;
    }
};