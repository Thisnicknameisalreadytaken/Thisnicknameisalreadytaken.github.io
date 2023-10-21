import java.util.Arrays;

class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        int res = 0;
        int t = 0;
        int f = 0;
        int max = 0;
        Arrays.sort(satisfaction);
        for (int i = 0; i < satisfaction.length; ++i) {
            if (satisfaction[i] < 0) {
                f += satisfaction[i];

            } else {
                t += satisfaction[i];
            }
            res += (i + 1) * satisfaction[i];
        }
        max = 0 > res ? 0 : res;
        for (int i = 0; i < satisfaction.length; ++i) {
            if (satisfaction[i] >= 0)
                break;
            res = res - t - f;
            f -= satisfaction[i];
            max = res > max ? res : max;
        }
        return max;
    }
}