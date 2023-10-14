import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        HashMap<Integer, Integer> num = new HashMap<>();
        for (int i : nums) {
            num.put(i, num.getOrDefault(i, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> temp : num.entrySet()) {
            if (temp.getValue() == 1)
                return temp.getKey();
        }
        return res;
    }

    public int sumDistance(int[] num) {
        Arrays.sort(num);
        int res = 0;
        int len = num.length;
        for (int i = 1; i < len; ++i) {
            res += (num[i] - num[i - 1]) * i * (len - i);
        }
        return res;
    }
}