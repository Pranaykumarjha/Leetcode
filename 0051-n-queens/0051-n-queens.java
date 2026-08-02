class Solution {

    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {

        char[][] board = new char[n][n];

        for (char[] row : board)
            Arrays.fill(row, '.');

        boolean[] cols = new boolean[n];
        boolean[] diag = new boolean[2 * n - 1];
        boolean[] antiDiag = new boolean[2 * n - 1];

        backtrack(0, board, cols, diag, antiDiag);

        return ans;
    }

    private void backtrack(int row, char[][] board,
                           boolean[] cols,
                           boolean[] diag,
                           boolean[] antiDiag) {

        int n = board.length;

        if (row == n) {

            List<String> temp = new ArrayList<>();

            for (char[] r : board)
                temp.add(new String(r));

            ans.add(temp);
            return;
        }

        for (int col = 0; col < n; col++) {

            int d = row - col + n - 1;
            int ad = row + col;

            if (cols[col] || diag[d] || antiDiag[ad])
                continue;

            board[row][col] = 'Q';
            cols[col] = true;
            diag[d] = true;
            antiDiag[ad] = true;

            backtrack(row + 1, board, cols, diag, antiDiag);

            board[row][col] = '.';
            cols[col] = false;
            diag[d] = false;
            antiDiag[ad] = false;
        }
    }
}