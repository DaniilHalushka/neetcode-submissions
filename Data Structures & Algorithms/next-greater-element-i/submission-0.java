class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nextGreater = new HashMap<>();
        Deque<Integer> deque = new ArrayDeque<>();

        for (int element : nums2) {
            while (!deque.isEmpty() && element > deque.peek()) {
                nextGreater.put(deque.pop(), element);
            }

            deque.push(element);
        }

        int[] result = new int[nums1.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = nextGreater.getOrDefault(nums1[i], -1);
        }

        return result;
    }
}