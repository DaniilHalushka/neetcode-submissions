class Solution {
    public int longestConsecutive(int[] nums) {
        int result = 0;
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        for (int element : set) {
            if (!set.contains(element - 1)) {
                int currentValue = element;
                int length = 1;

                while (set.contains(currentValue + 1)) {
                    currentValue++;
                    length++;
                }

                result = Math.max(result, length);
            }
        }

        return result;
    }
}