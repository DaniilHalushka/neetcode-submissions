class Solution {
    public int characterReplacement(String s, int k) {
        int[] frequency = new int[26];
        int left = 0, maxFreq = 0;
        int answer = 0;

        for (int right = 0; right < s.length(); right++) {
            frequency[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, frequency[s.charAt(right) - 'A']);

            if (right - left + 1 - maxFreq > k) {
                frequency[s.charAt(left) - 'A']--;
                left++;
            }

            answer = Math.max(answer, right - left + 1);
        }

        return answer;
    }
}
