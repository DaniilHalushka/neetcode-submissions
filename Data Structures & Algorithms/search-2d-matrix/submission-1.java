class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        int left = 0, right = rows * columns - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            int currentRow = middle / columns;
            int currentColumn = middle % columns;

            if (matrix[currentRow][currentColumn] < target) {
                left = middle + 1;
            } else if (matrix[currentRow][currentColumn] > target) {
                right = middle - 1;
            } else {
                return true;
            }
        }

        return false;
    }
}