class Solution {
    public void rotate(int[][] matrix) {
        int top = 0;
        int left = 0;
        int right = matrix.length - 1;
        int bottom = matrix[0].length - 1;

        while (left < right && top < bottom) {
            for (int i = 0; i < right - left; i++) {
                int temp = matrix[top][left + i];

                matrix[top][left + i] = matrix[bottom - i][left];
                matrix[bottom - i][left] = matrix[bottom][right - i];
                matrix[bottom][right - i] = matrix[top + i][right];
                matrix[top + i][right] = temp;
            }

            top++;
            left++;
            right--;
            bottom--;
        }
    }
}