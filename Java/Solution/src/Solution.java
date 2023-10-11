import java.util.Arrays;

class Solution {
    public int sumDistance(int[] nums, String s, int d) {
        long res = 0;
        long num[] = new long[nums.length];
        int mod = 10 ^ 9 + 7;
        int len = nums.length;
        for (int i = 0; i < len; ++i)
            num[i] = nums[i];
        len = s.length();
        for (int i = 0; i < len; ++i) {
            if (s.charAt(i) == 'L')
                num[i] -= d;
            else
                num[i] += d;
        }
        len = nums.length;
        Arrays.sort(num);
        for (int i = 1; i < len; ++i) {
            res += 1L * ((num[i] - num[i - 1]) * i % mod * (len - i) % mod);
            res %= mod;
        }
        return (int) res;
    }
}