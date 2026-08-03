class Solution {
    public void rotate(int[] nums, int k) {
        if (nums.length <= 1)
            return;
        int normalisedK = k % nums.length;

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, normalisedK - 1);
        reverse(nums, normalisedK, nums.length - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }
}
