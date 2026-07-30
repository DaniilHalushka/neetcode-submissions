class Solution {
    public int maxArea(int[] heights) {
        int left = 0, right = heights.length - 1;
        int maxSquare = 0;

        while (left < right) {
            int currentWidth = right - left;
            int currentHeight = Math.min(heights[left], heights[right]);

            maxSquare = Math.max(maxSquare, currentWidth * currentHeight);

            if (heights[left] <= heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxSquare;
    }
}
