class Solution {
    public int removeElement(int[] nums, int val) {
        //if we need to keep the original relative order of elements
        if (nums.length == 0) return 0;

        int write = 0;

        for (int read = 0; read < nums.length; read++) {
            if (nums[read] != val) {
                nums[write] = nums[read];
                write++;
            }
        }

        return write;
        
    }
}