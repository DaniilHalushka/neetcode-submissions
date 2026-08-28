class Solution {
    public boolean isSubsequence(String s, String t) {
        int sIterator = 0, tIterator = 0;

        while (sIterator < s.length() && tIterator < t.length()) {
            if (s.charAt(sIterator) == t.charAt(tIterator)) {
                sIterator++;
            }
            tIterator++;
        }

        return sIterator == s.length();
    }
}