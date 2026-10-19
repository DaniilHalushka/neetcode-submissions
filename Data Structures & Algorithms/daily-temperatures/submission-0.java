class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[temperatures.length];

        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!deque.isEmpty() && temperatures[i] >= temperatures[deque.peek()]) {
                deque.pop();
            }

            if (!deque.isEmpty()) {
                result[i] = deque.peek() - i;
            }

            deque.push(i);
        }

        return result;
    }
}
