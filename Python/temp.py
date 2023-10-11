from ast import List
import math


class Solution:
    def findTheArrayConcVal(self, nums: List[int]) -> int:
        res = 0
        length = len(nums)
        temp = ""
        for i in range(0, length):
            if i == length-i-1:
                break
            elif i != length-i-1:
                temp = temp+str(nums[i])+str(nums[i])
                res += int(temp)
            else:
                res += nums[i]
            temp = ""
        return res
