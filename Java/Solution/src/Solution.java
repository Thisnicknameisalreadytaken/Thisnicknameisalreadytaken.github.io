class Solution {
    public int punishmentNumber(int n) {
        int res = 0;
        int num[] = new int[] { 1, 9, 10, 36, 45, 55, 82, 91, 99, 100, 235, 297, 369, 370, 379, 414, 657, 675, 703, 756,
                792, 909, 918, 945, 964, 990, 991, 999, 1000 };
        int len = num.length;
        for (int i = 0; i < len; ++i) {
            if (num[i] > n)
                return res;
            res += (num[i] * num[i]);
        }
        return res;
    }
}