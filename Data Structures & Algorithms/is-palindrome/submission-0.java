class Solution {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            while (left < right && !isSymbolValid(s.charAt(left))) {
                left++;
            }

            while (left < right && !isSymbolValid(s.charAt(right))) {
                right--;
            }

            if (Character.toLowerCase(s.charAt(left)) == Character.toLowerCase(s.charAt(right))) {
                left++;
                right--;
            } else {
                return false;
            }
        }

        return true;
    }

    private boolean isSymbolValid(char symbol) {
        return (symbol >= 'A' && symbol <= 'Z') || (symbol >= 'a' && symbol <= 'z')
            || (symbol >= '0' && symbol <= '9');
    }
}

