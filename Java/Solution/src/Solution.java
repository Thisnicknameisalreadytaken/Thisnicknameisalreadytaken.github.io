import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() <= 10)
            return res;
        HashMap<String, Integer> hash = new HashMap<>();
        int len = s.length();
        String temp;
        for (int i = 9; i < len; ++i) {
            temp = s.substring(i - 9, i);
            hash.put(temp, hash.getOrDefault(temp, 0) + 1);
        }
        for (String key : hash.keySet()) {
            if (hash.get(key) > 1)
                res.add(key);
        }
        return res;
    }
}