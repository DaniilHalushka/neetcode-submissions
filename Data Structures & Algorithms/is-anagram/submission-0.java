class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] countArray = new int[26];

        for (int i = 0; i <= s.length() - 1; i++) {
            countArray[s.charAt(i) - 'a']++;
            countArray[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i <= countArray.length - 1; i++) {
            if (countArray[i] != 0) return false;
        }

        return true;
    }
}
