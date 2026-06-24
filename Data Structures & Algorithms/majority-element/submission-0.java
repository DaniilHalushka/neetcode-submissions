class Solution {
    public int majorityElement(int[] nums) {
        if (nums.length == 0) return 0;

        //Boyer–Moore majority vote algorithm
        int candidate = nums[0];
        int count = 0;

        for (int element : nums) {
            if (count == 0) {
                candidate = element;
                count++;
            } else if (candidate == element) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }
}