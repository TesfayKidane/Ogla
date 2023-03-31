package blind75.backtracking;

import java.util.*;

public class NQueens {

    private int size;
    private List<List<String>> solutions = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        this.size = n;
        // create hashmaps to indicate a queen is already placed in a col, positive diagonal and anti negative diagonal.
        Set<Integer> columns = new HashSet<>();
        Set<Integer> posDiagonal = new HashSet<>();
        Set<Integer> negDiagonal = new HashSet<>();

        // create a board of nxn size and initialize with false (every cell is empty at first)
        boolean[][] board = new boolean[size][size];
        // initialize every cell with empty
        for(boolean[] row : board) {
            Arrays.fill(row, false);
        }

        backtrack(board, columns, posDiagonal, negDiagonal, 0);
        return solutions;
    }

    private void backtrack(boolean[][] board, Set<Integer> columns, Set<Integer> posDiagonal, Set<Integer> negDiagonal, int row) {
        if(row == size) {
            solutions.add(createAnswer(board));
        }

        // for the given row, check if it's possible to check every column, positive digonal and negative diagonal.
        for(int c = 0 ; c < board[0].length; c++) {

            // if queen is already placed in column C, pos diagonal R - C or negative diagonal R + C then skip
            if(columns.contains(c) ||
            posDiagonal.contains(row - c) ||
            negDiagonal.contains(row + c)) {
                continue;
            }

            // add Queen
            columns.add(c);
            posDiagonal.add(row - c);
            negDiagonal.add(row + c);
            board[row][c] = true;

            // now that we placed a queen on the current row, let's work on the next row
            backtrack(board, columns, posDiagonal, negDiagonal, row + 1);

            // since we are using backtrack, we should remove what was added.
            columns.remove(c);
            posDiagonal.remove(row - c);
            negDiagonal.remove(row + c);
            board[row][c] = false;
        }

    }

    private List<String> createAnswer(boolean[][] board) {
        List<String> result = new ArrayList<>();
        for(int r = 0; r < board.length; r++) {
            StringBuilder temp = new StringBuilder();
            for(int c = 0; c < board[0].length; c++) {
                if(board[r][c]) {
                    temp.append("Q");
                } else {
                    temp.append(".");
                }
            }
            result.add(temp.toString());
            temp.setLength(0);
        }
        return result;
    }
}
