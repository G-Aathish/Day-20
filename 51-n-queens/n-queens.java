import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        
        // Initialize an empty chessboard filled with '.'
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        
        // Use lookup arrays to track attacked columns and diagonals in O(1) time
        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2 * n]; // Main diagonals: row + col
        boolean[] diag2 = new boolean[2 * n]; // Anti-diagonals: row - col + n

        backtrack(0, n, board, result, cols, diag1, diag2);
        return result;
    }

    private void backtrack(int row, int n, char[][] board, List<List<String>> result, 
                           boolean[] cols, boolean[] diag1, boolean[] diag2) {
        // Base case: All queens are successfully placed
        if (row == n) {
            result.add(constructBoard(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            int d1 = row + col;
            int d2 = row - col + n;

            // Skip placement if the position is under attack
            if (cols[col] || diag1[d1] || diag2[d2]) {
                continue;
            }

            // Place queen
            board[row][col] = 'Q';
            cols[col] = diag1[d1] = diag2[d2] = true;

            // Recurse to place the queen in the next row
            backtrack(row + 1, n, board, result, cols, diag1, diag2);

            // Backtrack: Remove queen and reset tracking states
            board[row][col] = '.';
            cols[col] = diag1[d1] = diag2[d2] = false;
        }
    }

    // Helper method to convert char[][] board layout to the required List<String> format
    private List<String> constructBoard(char[][] board) {
        List<String> path = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            path.add(new String(board[i]));
        }
        return path;
    }
}
