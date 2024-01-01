class Solution {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int res = 0;
        int max = -1;
        int time = 0;
        int ans = -1;
        int len = customers.length;
        int margin = 0;
        for (int i = 0; i < len; ++i) {
            ++time;
            margin += customers[i];
            if (margin >= 4) {
                margin -= 4;
                res += boardingCost * 4 - runningCost;
                if (res > max) {
                    max = res;
                    ans = time;
                }
            } else {
                res += boardingCost * margin - runningCost;
                if (res > max) {
                    max = res;
                    ans = time;
                }
                margin = 0;
            }
        }
        while (margin > 0) {
            ++time;
            if (margin >= 4) {
                margin -= 4;
                res += boardingCost * 4 - runningCost;
                if (res > max) {
                    max = res;
                    ans = time;
                }
            } else {
                res += boardingCost * margin - runningCost;
                if (res > max) {
                    max = res;
                    ans = time;
                }
                margin = 0;
            }
        }
        if (max <= 0)
            return -1;
        return ans;
    }
}