class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int a[] = new int[26];
        int b[] = new int[26];
        int len = ransomNote.length();
        for (int i = 0; i < len; i++) {
            a[ransomNote.charAt(i) - 'a']++;
        }
        len = magazine.length();
        for (int i = 0; i < len; i++) {
            b[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (a[i] > b[i]) {
                return false;
            }
        }
        return true;
    }
}