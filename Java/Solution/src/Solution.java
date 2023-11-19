class Solution {
    public int maxSubArray(int[] nums) {
        int res = -0x3f3f3f3f;
        int max = nums[0];
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            if (max <= 0) {
                max = nums[i];
            } else {
                max += nums[i];
            }
            res = Math.max(res, max);
        }
        return res;
    }
}