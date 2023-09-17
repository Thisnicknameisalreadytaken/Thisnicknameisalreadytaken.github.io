from ast import List


class Solution:
    def rob(self, nums: List[int]) -> int:
        res1, res2 = 0, 0
        head = nums[0]
        length = len(nums)
        if length == 1:
            return nums[0]
        elif length == 2:
            return max(nums[0], nums[1])
        nums[0] = 0
        l, r = 0, nums[1]
        temp = 0
        for i in range(2, length):
            temp = r
            res1 = max(l+nums[i], r)
            r = res1
            l = temp
        nums[0], nums[length-1] = head, 0
        l, r = nums[0], max(nums[0], nums[1])
        for i in range(2, length):
            temp = r
            res2 = max(l+nums[i], r)
            r = res2
            l = temp
        return max(res1, res2)
