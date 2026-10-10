class Solution {
    public boolean isValid(String s) {
        Deque<Character> deque = new ArrayDeque<>();

        for (char symbol : s.toCharArray()) {
            switch (symbol) {
                case '(', '{', '[' -> {
                    deque.addFirst(symbol);
                }
                case ')' -> {
                    if(!deque.isEmpty() && deque.peekFirst() == '(') {
                        deque.removeFirst();
                    } else return false;
                }
                case '}' -> {
                    if(!deque.isEmpty() && deque.peekFirst() == '{') {
                        deque.removeFirst();
                    } else return false;
                }
                case ']' -> {
                    if(!deque.isEmpty() && deque.peekFirst() == '[') {
                        deque.removeFirst();
                    } else return false;
                }
                default -> {
                    return false;
                }
            }
        }

        return deque.isEmpty();
    }
}