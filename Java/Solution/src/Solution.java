import java.util.Arrays;

class Solution {
    public int singleNumber(int[] nums) {
        int[] num = new int[60005];
        Arrays.fill(num, 0);
        for (int i : nums) {
            ++num[i - 30002];
        }
        for (int i = 0; i < 60005; ++i) {
            if (num[i] == 1)
                return i - 30002;
        }
        return 0;
    }
}