class Solution {
    public String minWindow(String s, String t) {
        int sourceLength = s.length();
        int targetLength = t.length();

        int[] symbolFreq = new int[128];
        int[] windowFreq = new int[128];

        for (char symbol : t.toCharArray()) {
            symbolFreq[symbol]++;
        }

        int minWindowStart = -1;
        int minWindowLength = Integer.MAX_VALUE;
        int validCharCount = 0;
        int left = 0;

        for (int right = 0; right < sourceLength; right++) {
            char rightChar = s.charAt(right);
            windowFreq[rightChar]++;

            if (windowFreq[rightChar] <= symbolFreq[rightChar]) {
                validCharCount++;
            }

            while (validCharCount == targetLength) {
                if (right - left + 1 < minWindowLength) {
                    minWindowLength = right - left + 1;
                    minWindowStart = left;
                }

                char leftChar = s.charAt(left);
                if (windowFreq[leftChar] <= symbolFreq[leftChar]) {
                    validCharCount--;
                }

                windowFreq[leftChar]--;
                left++;
            }
        }

        return minWindowStart == -1 ? ""
                                    : s.substring(minWindowStart, minWindowStart + minWindowLength);
    }
}
