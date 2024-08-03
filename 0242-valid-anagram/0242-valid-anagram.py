class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if(len(s) != len(t)):
            return False
        
        d = defaultdict(lambda: 0)

        for ch in s:
            d[ch] += 1
        
        for ch in t:
            d[ch] -= 1

        for val in d.values():
            if val:
                return False

        return True