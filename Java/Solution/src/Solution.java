import java.util.HashMap;
import java.util.Map;

class Solution {
    public int countWords(String[] words1, String[] words2) {
        int res = 0;
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for (String word : words1) {
            map1.put(word, map1.getOrDefault(word, 0) + 1);
        }
        for (String word : words2) {
            map2.put(word, map2.getOrDefault(word, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            if (map2.containsKey(entry.getKey()) && map2.get(entry.getKey()) * entry.getValue() == 1) {
                ++res;
            }
        }
        return res;
    }
}