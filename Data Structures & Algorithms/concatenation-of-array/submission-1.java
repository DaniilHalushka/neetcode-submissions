class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] resultArray = new int[2 * nums.length];

        for (int i = 0; i <= nums.length - 1; i++) {
            resultArray[i] = nums[i];
            resultArray[i + nums.length] = nums[i];
        }
        
        return resultArray;
    }
}