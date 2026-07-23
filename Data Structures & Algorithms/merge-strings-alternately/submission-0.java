class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int firstWordPointer = 0, secondWordPointer = 0;

        while (firstWordPointer < word1.length() && secondWordPointer < word2.length()) {
            result.append(word1.charAt(firstWordPointer));
            result.append(word2.charAt(secondWordPointer));
            firstWordPointer++;
            secondWordPointer++;
        }

        result.append(word1.substring(firstWordPointer));
        result.append(word2.substring(secondWordPointer));

        return result.toString();
    }
}