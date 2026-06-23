class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            int symbolCount = 0;
            int maxLength = Math.min(strs[i].length(), prefix.length());

            while (symbolCount < maxLength && strs[i].charAt(symbolCount) == prefix.charAt(symbolCount)) {
                symbolCount++;
            }

            prefix = prefix.substring(0, symbolCount);
        }

        return prefix;
    }
}