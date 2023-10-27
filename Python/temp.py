from ast import List
import math


class Solution:
    def countDigits(self, num: int) -> int:
        strnum = str(num)
        res = 0
        for i in strnum:
            if num % int(i) == 0:
                res += 1
        return res
