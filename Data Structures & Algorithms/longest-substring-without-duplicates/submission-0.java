class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set window = new HashSet<>();
        int left = 0, maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            while (window.contains(s.charAt(right))) {
                window.remove(s.charAt(left));
                left++;
            }

            window.add(s.charAt(right));
            maxLength = Math.max(maxLength, window.size());
        }

        return maxLength;
    }
}
