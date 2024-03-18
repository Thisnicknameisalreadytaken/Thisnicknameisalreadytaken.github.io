import math
import sys
from typing import Counter, List, Optional


class NumArray:

    num = [0]*200000

    def __init__(self, nums: List[int]):
        for i in range(len(nums)):
            self.num[i+1] = self.num[i]+nums[i]

    def sumRange(self, left: int, right: int) -> int:
        return self.num[right+1]-self.num[left]
