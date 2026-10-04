//handwrited solution using deque
//we need to keep monotonic decrease deque

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            //remove elements if left window pointer > first element in deque
            while (!deque.isEmpty() && i - k + 1 > deque.peekFirst()) {
                deque.removeFirst();
            }

            //remove elements if current digit > last in deque
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.removeLast();
            }

            deque.addLast(i);

            if (i - k + 1 >= 0) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return result;
    }
}
