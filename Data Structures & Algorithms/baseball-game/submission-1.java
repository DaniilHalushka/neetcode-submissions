//stack is depricated, use Deque

class Solution {
    public int calPoints(String[] operations) {
        Deque<Integer> deque = new ArrayDeque<>();
        int totalSum = 0;

        for (String op : operations) {
            switch(op) {
                case "+" -> {
                    int top = deque.removeFirst();
                    int newTop = top + deque.peekFirst();
                    deque.addFirst(top);
                    deque.addFirst(newTop);
                    totalSum += deque.peekFirst();
                }

                case "D" -> {
                    deque.addFirst(deque.peekFirst() * 2);
                    totalSum += deque.peekFirst();
                }

                case "C" -> {
                    totalSum -= deque.peekFirst();
                    deque.removeFirst();
                }

                default -> {
                    deque.addFirst(Integer.parseInt(op));
                    totalSum += deque.peekFirst();
                }
            }
        }

        return totalSum;
    }
}