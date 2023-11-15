from ast import List
import math

class Solution:
    def maximizeSum(self, nums: List[int], k: int) -> int:
        return nums.max()*k+k*(k-1)/2