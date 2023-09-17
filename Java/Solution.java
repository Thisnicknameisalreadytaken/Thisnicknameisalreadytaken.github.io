class Solution {
    public int rob(int[] nums) {
        int res1 = 0, res2 = 0;
        int head = nums[0], len = nums.length, temp;
        nums[0] = 0;
        if (len == 1)
            return nums[0];
        else if (len == 2)
            return Math.max(nums[0], nums[1]);
        nums[0] = 0;
        int l = nums[0], r = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; ++i) {
            temp = r;
            res1 = Math.max(l + nums[i], r);
            r = res1;
            l = temp;
        }
        nums[0] = head;
        nums[len - 1] = 0;
        for (int i = 2; i < len; ++i) {
            temp = r;
            res2 = Math.max(l + nums[i], r);
            r = res2;
            l = temp;
        }
        return res1 > res2 ? res1 : res2;
    }
}