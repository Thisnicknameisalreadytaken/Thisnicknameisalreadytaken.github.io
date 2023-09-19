from ast import List
import math


class Solution:
    def minCapability(self, nums: List[int], k: int) -> int:
        l, r, res = 0x3f3f3f3f, -0x3f3f3f3f, 0
        for i in nums:
            l = math.min(l, i)
            r = math.max(r, i)
        sum, judge = 0, 1
        while l != r:
            sum, judge = 0, 1
            res = int((l+r)/2)
            for i in nums:
                if judge == 1 and i <= k:
                    sum += 1
                    judge = 0
                else:
                    judge = 1
            if sum >= k:
                r = res
            else:
                l = res+1
        return l
