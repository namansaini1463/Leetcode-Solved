def defaultValue():
    return 0

class Solution:

    def canBeEqual(self, target: List[int], arr: List[int]) -> bool:
        d = defaultdict(defaultValue)
        for t in target:
            d[t] += 1
        
        for a in arr:
            d[a] -= 1
        
        for val in d.values():
            if(val):
                return False

        return True
        