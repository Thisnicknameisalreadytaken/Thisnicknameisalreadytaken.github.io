public class Solution {
    public int add(int a, int b) {
        return a + b;
    }

    public int sum(int nums[]) {
        int res = 0, len = nums.length;
        for (int i = 0; i < len; ++i)
            res += nums[i];
        return res;
    }

    public int total(int nums[][]) {
        int res = 0;
        for (int[] temp : nums) {
            for (int num : temp) {
                res += num;
            }
        }
        return res;
    }
}
