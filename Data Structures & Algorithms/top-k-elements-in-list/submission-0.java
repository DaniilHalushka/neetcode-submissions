class Solution {
    //not optimal; it needs to be rewritten using a priority queue.
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int element : nums) {
            map.put(element, map.getOrDefault(element, 0) + 1);
        }

        for (int i = 0; i < k; i++) {
            int maxKey = 0;
            int maxFreq = Integer.MIN_VALUE;

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() > maxFreq) {
                    maxFreq = entry.getValue();
                    maxKey = entry.getKey();
                }
            }

            result[i] = maxKey;
            map.remove(maxKey);
        }

        return result;
    }
}