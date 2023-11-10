import java.util.*;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int lens = spells.length;
        int res[] = new int[lens];
        Arrays.sort(potions);
        int len = potions.length;
        int left = 0, right = len - 1;
        int mid = (left + right) >> 1;
        for (int i = 0; i < lens; i++) {
            left = 0;
            right = len - 1;
            while (left <= right) {
                mid = (left + right) >> 1;
                if (1L * spells[i] * potions[mid] >= success) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            res[i] = len - mid;
        }
        return res;
    }
}