import java.util.*;

class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int res = 0;
        int max = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (max == 0 && nums[i] % 2 == 0 && nums[i] <= threshold) {
                max = 1;
            } else if (max != 0 && nums[i] % 2 != nums[i - 1] % 2 && nums[i] <= threshold) {
                max++;
            } else {
                res = Math.max(res, max);
                max = 0;
                if (nums[i] % 2 == 0 && nums[i] <= threshold)
                    max = 1;
            }
        }
        res = Math.max(res, max);
        return res;
    }
}