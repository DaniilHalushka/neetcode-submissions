class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] columns = new boolean[9][9];
        boolean[][] squares = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int index = board[i][j] - '1';
                    int squareIndex = (i / 3) * 3 + (j / 3);

                    if (rows[i][index] || columns[j][index] || squares[squareIndex][index]) {
                        return false;
                    }

                    rows[i][index] = columns[j][index] = squares[squareIndex][index] = true;
                }
            }
        }

        return true;
    }
}