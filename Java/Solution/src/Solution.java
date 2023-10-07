class StockSpanner {

    public StockSpanner() {

    }

    int num[] = new int[10002];
    int len = 0;

    public int next(int price) {
        num[len++] = price;
        int res = 0;
        int max = 0;
        for (int i = len - 1; i >= 0; --i) {
            if (price >= num[i]) {
                ++max;
            } else {
                res = Math.max(res, max);
                max = 0;
            }
        }
        res = Math.max(res, max);
        return res;
    }
}