import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int len = plantTime.length;
        int res[] = new int[len];
        int time[][] = new int[len][2];
        int ans = 0;
        for (int i = 0; i < len; ++i) {
            time[i][0] = plantTime[i] + growTime[i];
            time[i][1] = growTime[i];
        }
        Arrays.sort(time, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1];
            }
        });
        int day = 0;
        for (int i = 0; i < len; ++i) {
            res[i] = Math.max(res[i], day + time[i][0]);
            day += (time[i][0] - time[i][1]);
        }
        ans = res[len - 1];
        for (int i = len - 1; i >= 0; --i) {
            if (res[i] - time[i][0] > res[i - 1] + time[i][0] - time[i][1]) {
                ans = res[i - 1] + time[i][0] - time[i][1];
            } else
                break;
        }
        return ans;
    }
}