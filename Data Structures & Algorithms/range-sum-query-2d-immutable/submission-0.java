class NumMatrix {

    private int[][] prefixSum;

    public NumMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        prefixSum = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                prefixSum[i][j] = matrix[i - 1][j - 1] + prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1];
            }
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int incRow1 = row1 + 1;
        int incRow2 = row2 + 1;
        int incCol1 = col1 + 1;
        int incCol2 = col2 + 1;

        return prefixSum[incRow2][incCol2] - prefixSum[incRow1 - 1][incCol2] - prefixSum[incRow2][incCol1 - 1] + prefixSum[incRow1 - 1][incCol1 - 1];
    }
}