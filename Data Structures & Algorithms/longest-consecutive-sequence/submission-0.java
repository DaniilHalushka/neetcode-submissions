class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int quantity = 0;
        for (int element : set) {
            if (!set.contains(element - 1)) {
                int currentValue = element;
                int length = 1;

                while (set.contains(currentValue + 1)) {
                    currentValue++;
                    length++;
                }

                quantity = Math.max(quantity, length);
            }
        }

        return quantity;
        
    }
}