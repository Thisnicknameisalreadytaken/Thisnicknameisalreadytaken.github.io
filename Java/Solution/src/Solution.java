class Solution {
    public int hIndex(int[] citations) {
        int res = citations.length;
        for (int i = 0; i < res / 2; ++i) {
            citations[i] ^= citations[res - i - 1];
            citations[res - i - 1] ^= citations[i];
            citations[i] ^= citations[res - i - 1];
        }
        for (int i = 0; i < res; ++i) {
            if (citations[i] <= i)
                return i;
        }
        return res;
    }
}