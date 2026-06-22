class Solution {
    public boolean isValid(String s) {
        if (s.isEmpty()) return false;

        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char ch : charArray) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (stack.isEmpty()) {
                return false;
            } else if (ch == ')') {
                if (stack.peek() != '(') return false; else stack.pop();
            } else if (ch == '}') {
                if (stack.peek() != '{') return false; else stack.pop();
            } else if (ch == ']') {
                if (stack.peek() != '[') return false; else stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
