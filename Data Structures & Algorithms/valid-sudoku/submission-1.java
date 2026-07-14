class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] columns = new HashSet[9];
        HashSet<Character>[] squares = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            columns[i] = new HashSet<>();
            squares[i] = new HashSet<>();
        }

        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                if (board[row][column] == '.') {
                    continue;
                }

                char currentValue = board[row][column];
                int squareIndex = (row / 3) * 3 + column / 3; //* for vertical shift

                if (rows[row].contains(currentValue) || columns[column].contains(currentValue)
                    || squares[squareIndex].contains(currentValue)) {
                    return false;
                }

                rows[row].add(currentValue);
                columns[column].add(currentValue);
                squares[squareIndex].add(currentValue);
            }
        }

        return true;
    }
}
