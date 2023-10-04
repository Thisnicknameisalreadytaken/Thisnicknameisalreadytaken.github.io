class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        int len = prices.length;
        int judge = 0;
        for (int i = 0; i < len - 1; ++i) {
            if (prices[i] > prices[i + 1])
                judge = 1;
        }
        if (judge == 0)
            return prices[len - 1] - prices[0];
        int min1 = 0x3f3f3f3f;
        int min2 = 0;
        int max1 = 0;
        int max2 = 0;
        int temp1 = 0, temp2 = 0;
        for (int i = 0; i < len; ++i) {
            min1 = Math.min(min1, prices[i]);
            max1 = Math.max(max1, prices[i] - min1);
            if (temp1 < i || temp2 < i) {
                min2 = i;
                max2 = 0;
                temp1 = 0;
                temp2 = 0;
                for (int j = i; j < len; ++j) {
                    if (prices[min2] > prices[j])
                        min2 = j;
                    else if (max2 < prices[j] - prices[min2]) {
                        temp1 = min2;
                        temp2 = j;
                        max2 = prices[j] - prices[min2];
                    }
                }
            }
            res = Math.max(res, max1 + prices[temp2] - prices[temp1]);
        }
        return res;
    }
}