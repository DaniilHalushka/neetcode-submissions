class Solution {
    public int trap(int[] height) {
        if (height.length <= 2)
            return 0;

        int left = 0, right = height.length - 1;
        int maxLeft = height[left], maxRight = height[right];
        int answer = 0;

        while (left < right) {
            if (maxLeft < maxRight) {
                left++;
                maxLeft = Math.max(maxLeft, height[left]);
                answer += maxLeft - height[left];
            } else {
                right--;
                maxRight = Math.max(maxRight, height[right]);
                answer += maxRight - height[right];
            }
        }

        return answer;
    }
}
