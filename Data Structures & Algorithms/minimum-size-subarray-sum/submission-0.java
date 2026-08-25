
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int currentSum = 0, left = 0;
        int answer = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right];
            while (currentSum >= target) {
                answer = Math.min(answer, right - left + 1);
                currentSum -= nums[left];
                left++;
            }
        }

        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
}