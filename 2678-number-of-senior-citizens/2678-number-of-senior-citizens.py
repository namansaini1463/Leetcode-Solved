class Solution(object):
    def countSeniors(self, details):
        """
        :type details: List[str]
        :rtype: int
        """
        count = 0
        for detailsString in details:
            age = int(detailsString[11])*10 + int(detailsString[12])
            print(age)

            if (age > 60): count = count + 1
        return count
        