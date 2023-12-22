import java.util.Arrays;

class Solution {
    public boolean closeStrings(String word1, String word2) {
        int num1[] = new int[26];
        int num2[] = new int[26];
        int len1 = word1.length();
        int len2 = word2.length();
        if (len1 != len2)
            return false;
        for (int i = 0; i < len1; i++) {
            num1[word1.charAt(i) - 'a']++;
            num2[word2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (num1[i] != 0 && num2[i] == 0 || num1[i] == 0 && num2[i] != 0)
                return false;
        }
        Arrays.sort(num1);
        Arrays.sort(num2);
        for (int i = 0; i < 26; i++) {
            if (num1[i] != num2[i])
                return false;
        }
        return true;
    }
}