class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] columns = new boolean[9][9];
        boolean[][] squares = new boolean[9][9];

        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                if (board[row][column] == '.') {
                    continue;
                }

                int digit = board[row][column] - '1';
                int squareIndex = (row / 3) * 3 + column / 3; //* for vertical shift

                if (rows[row][digit] || columns[column][digit] || squares[squareIndex][digit]) {
                    return false;
                }

                rows[row][digit] = true;
                columns[column][digit] = true;
                squares[squareIndex][digit] = true;
            }
        }

        return true;
    }
}
