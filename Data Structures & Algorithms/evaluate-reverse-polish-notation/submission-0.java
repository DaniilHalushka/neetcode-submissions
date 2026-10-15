class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> deque = new ArrayDeque<>();

        for (String symbol : tokens) {
            switch (symbol) {
                case "+" -> {
                    int value = deque.pop();
                    deque.push(deque.pop() + value);
                }
                case "-" -> {
                    int subtrahend = deque.pop();
                    int minuend = deque.pop();
                    deque.push(minuend - subtrahend);
                }
                case "*" -> {
                    int value = deque.pop();
                    deque.push(deque.pop() * value);
                }
                case "/" -> {
                    int divisor = deque.pop();
                    int dividend = deque.pop();
                    deque.push(dividend / divisor);
                }
                default -> {
                    deque.push(Integer.parseInt(symbol));
                }
            }
        }

        return deque.peek();
    }
}