import java.util.Arrays;

class Solution {
    public int splitNum(int num) {
        int res = 0;
        int nums[] = new int[11];
        int len = 0;
        while (num != 0) {
            nums[len++] = num % 10;
            num /= 10;
        }
        Arrays.sort(nums);
        len = 11;
        for (int i = 0; i < len; ++i) {
            int temp = nums[i];
            if (i % 2 == 0) {
                for (int j = 1; j < len / 2 - i / 2 + 1; ++j) {
                    temp *= 10;
                }
            } else {
                for (int j = 1; j < len / 2 - i / 2; ++j) {
                    temp *= 10;
                }
            }
            res += temp;
        }

        return res;
    }
}