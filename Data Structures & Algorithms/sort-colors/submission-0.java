class Solution {
    //since there are only three values ​​here, we can use the Dutch National Flag Problem Algorithm
    public void sortColors(int[] nums) {
        int low = 0;
        int middle = 0;
        int high = nums.length - 1;

        while (middle <= high) {
            if (nums[middle] == 1) {
                middle++;
            } else if (nums[middle] < 1) {
                int temp = nums[low];
                nums[low] = nums[middle];
                nums[middle] = temp;
                low++;
                middle++;
            } else {
                int temp = nums[high];
                nums[high] = nums[middle];
                nums[middle] = temp;
                high--;
            }
        }
        
    }
}