class Solution {
    public int minCapability(int[] nums, int k) {
        int len = nums.length;
        int l = 0x3f3f3f3f, r = -0x3f3f3f3f, res = 0;
        for (int i = 0; i < len; ++i) {
            l = Math.min(l, nums[i]);
            r = Math.max(r, nums[i]);
        }
        Boolean judge = true;
        int sum = 0;
        while (l != r) {
            res = (l + r) / 2;
            sum = 0;
            judge = true;
            for (int i = 0; i < len; ++i) {
                if (judge && nums[i] <= res) {
                    ++sum;
                    judge = false;
                } else
                    judge = true;
            }
            if (sum >= k)
                r = res;
            else
                l = res + 1;
        }
        return res;
    }
}