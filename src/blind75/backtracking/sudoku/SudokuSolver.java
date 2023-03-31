package blind75.backtracking.sudoku;

import java.lang.Math;
import java.util.HashSet;

// HARD
public class SudokuSolver {
    int boxSize = 3;
    int boardSize = boxSize * boxSize;
    int[][] board;
    boolean sudokuSolved = false;

    HashSet<Integer>[] rows = new HashSet[boardSize];
    HashSet<Integer>[] columns = new HashSet[boardSize];
    HashSet<Integer>[] boxes = new HashSet[boardSize];

    // initializes the hashset arrays
    private void initialize() {

        for(int i = 0 ; i < boardSize; i++) {
            rows[i] = new HashSet<>();
            columns[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }
    }

    // calculate the box id using formula
    private int getBoxId(int r, int c) {
        return (r/boxSize)*boxSize + c/boxSize;
    }

    // check if a number can be placed in a given cell in the board
    private boolean canBePlaced(int r, int c, int num) {
        return !rows[r].contains(num) &&
               !columns[c].contains(num) &&
               !boxes[getBoxId(r, c)].contains(num);
    }

    // place a number in a given cell in the board
    private void placeNumber(int r, int c, int num) {
        rows[r].add(num);
        columns[c].add(num);
        boxes[getBoxId(r,c)].add(num);
        board[r][c] = num;
    }

    // remove a number from a given cell in the board
    private void removeNumber(int r, int c, int num) {
        rows[r].remove(num);
        columns[c].remove(num);
        boxes[getBoxId(r,c)].remove(num);
        board[r][c] = 0;
    }

    private void placeNextNumbers(int r, int c) {
        if(r == boardSize - 1 && c == boardSize - 1) {
            sudokuSolved = true;
        }
        else {
            // if we are at the end column of a given row
            // then go to the first column of the next row.
            if (c == boardSize - 1) {
                backTracking(r + 1, 0);
            }
            // else go to the next column on the same row.
            else {
                backTracking(r, c + 1);
            }
        }
    }

    private void backTracking(int r, int c) {
        // if the given board cell is empty (0)
        // then try to fill it with numbers from 1 to 9;
        if(board[r][c] == 0) {
            for(int num = 1; num <= 9; num++) {
                if(canBePlaced(r, c, num)) {
                    placeNumber(r, c, num);
                    placeNextNumbers(r, c);

                    // sudoku is not solved with this number
                    // then remove it from the hashset array and try next;
                    if(!sudokuSolved) {
                        removeNumber(r, c, num);
                    }
                }
            }
        } else {
            placeNextNumbers(r, c);
        }
    }

    public int[][] solveSudoku(int[][] board) {
        this.board = board;
        initialize();

        // iterate through each cell in the input board and initialize the hashset arrays
        for(int r = 0 ; r < boardSize; r++) {
            for(int c = 0 ; c < boardSize; c++) {
                if(board[r][c] != 0) {
                    placeNumber(r, c, board[r][c]);
                }
            }
        }

        // start backtracking from [0,0]
        backTracking(0, 0);
        return board;
    }

    public static void main(String[] args) {
        int[][] board1Input = new int[][]{
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}};

        int[][] expectedBoard1Output = new int[][]{
                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 9}};


        SudokuSolver ss = new SudokuSolver();
        int[][] board1Output = ss.solveSudoku(board1Input);
        System.out.println(assertTrueSudokuSolverResult(board1Output, expectedBoard1Output));
    }

    private static boolean assertTrueSudokuSolverResult(int[][] b1, int[][] b2) {
        for(int r = 0 ; r < 9; r++) {
            for (int c = 0 ; c < 9; c++) {
                if(b1[r][c] != b2[r][c]) {
                    return false;
                }
                System.out.println();
            }
        }
        return true;
    }

}
