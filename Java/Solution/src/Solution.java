class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int res = 0;
        if (n == 0)
            return true;
        int len = flowerbed.length;
        if (len == 1)
            return flowerbed[0] == 0 && n == 1;
        else if (len == 2)
            return flowerbed[0] + flowerbed[1] == 0 && n == 1;
        if (flowerbed[0] + flowerbed[1] == 0) {
            ++res;
            flowerbed[0] = 1;
        }
        if (flowerbed[len - 1] + flowerbed[len - 2] == 0) {
            ++res;
            flowerbed[len - 1] = 1;
        }
        for (int i = 1; i < len - 1; ++i) {
            if (flowerbed[i - 1] + flowerbed[i] + flowerbed[i + 1] == 0) {
                ++res;
                flowerbed[i] = 1;
            }
        }
        return res >= n;
    }
}