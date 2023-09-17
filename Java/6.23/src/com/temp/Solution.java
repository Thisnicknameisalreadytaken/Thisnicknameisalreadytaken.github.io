import java.util.HashSet;

class Solution {
    public boolean queryString(String s, int n) {
        int temp = 0;
        HashSet<Object> hashSet = new HashSet<>();
        for (int i = 0, len = s.length(); i < len; ++i) {
            temp = s.charAt(i) - '0';
            if (temp == 0)
                continue;
            for (int j = i + 1; temp <= n; ++j) {
                hashSet.add(temp);
                if (j == len)
                    break;
                temp = temp << 1 | (s.charAt(j) - '0');
            }
        }
        return n == hashSet.size();
    }
}