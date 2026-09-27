class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1) return nums;

        int[] result = new int[nums.length - k + 1];
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            // remove indices outside window
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.removeFirst();
            }

            // maintain monotonic decreasing order
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.removeLast();
            }

            deque.addLast(i);

            // window is full
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return result;
    }
}