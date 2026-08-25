
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] firstFreq = new int[26];
        int[] secondFreq = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            firstFreq[s1.charAt(i) - 'a']++;
        }

        int left = 0;
        for (int right = 0; right < s2.length(); right++) {
            secondFreq[s2.charAt(right) - 'a']++;
            int windowSize = right - left + 1;

            if (windowSize > s1.length()) {
                secondFreq[s2.charAt(left) - 'a']--;
                left++;
            }

            if (match(firstFreq, secondFreq))
                return true;
        }

        return false;
    }

    private boolean match(int[] firstFreq, int[] secondFreq) {
        for (int i = 0; i < 26; i++) {
            if (firstFreq[i] != secondFreq[i])
                return false;
        }

        return true;
    }
}
