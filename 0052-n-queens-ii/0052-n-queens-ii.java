class Solution {
    public int totalNQueens(int n) {
        return solve(0, n, new char[n][n]);
    }

    private int solve(int row, int n, char[][] board) {
        if (row == n) {
            return 1;
        }

        int count = 0;

        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                count += solve(row + 1, n, board);
                board[row][col] = '\0';
            }
        }

        return count;
    }

    private boolean isSafe(char[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }
}