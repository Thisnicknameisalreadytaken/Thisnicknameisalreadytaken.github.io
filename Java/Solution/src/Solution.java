class Solution {
    public int minCount(int[] coins) {
        int res = 0;
        for (int i : coins) {
            res += (i + 1) / 2;
        }
        return res;
    }
}