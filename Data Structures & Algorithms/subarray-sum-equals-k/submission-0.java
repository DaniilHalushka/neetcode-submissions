class Solution {
    public int subarraySum(int[] nums, int k) {
        int prefixSum = 0, countAnswer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        for (int element : nums) {
            prefixSum += element;
            int currentDifference = prefixSum - k;
            countAnswer += map.getOrDefault(currentDifference, 0);
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return countAnswer;
    }
}
