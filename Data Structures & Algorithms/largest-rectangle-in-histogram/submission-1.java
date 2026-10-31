class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> deque = new ArrayDeque<>();
        int maxSquare = 0;

        for (int i = 0; i <= heights.length; i++) {
            int currentHeight = (i == heights.length) ? 0 : heights[i];
            while (!deque.isEmpty() && heights[deque.peek()] > currentHeight) {
                int poppedIndex = deque.pop();
                int height = heights[poppedIndex];
                int currentWidth = deque.isEmpty() ? i : i - deque.peek() - 1;

                maxSquare = Math.max(maxSquare, height * currentWidth);
            }

            deque.push(i);
        }

        return maxSquare;
    }
}