class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len <= 1)
            return 0;
        int buy[] = new int[len];
        int sell[] = new int[len];
        buy[0] = -prices[0];
        sell[0] = 0;
        buy[1] = Math.max(-prices[0], -prices[1]);
        sell[1] = Math.max(0, buy[0] - prices[1]);
        for (int i = 2; i < len; ++i) {
            buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
        }
        return sell[len - 1];
    }
}