package blind75.backtracking.sudoku;

public class SudokuSolverApple {

    // box size
    int boxSize = 3;
    // row size
    int boardSize = boxSize * boxSize;
    int[][] board;
    boolean sudokuSolved = false;

    int [][] numsInRows = new int[boardSize][boardSize + 1];
    int [][] numsInColumns = new int[boardSize][boardSize + 1];
    int [][] numsInBoxes = new int[boardSize][boardSize + 1];

    // Calculate box id using a formula.
    public int getBoxId(int r, int c) {
        return (r / boxSize) * boxSize + c / boxSize;
    }

    // Check if given number can be placed in given cell of the board.
    public boolean couldBePlacedInCell(int d, int r, int c) {
        int idx = getBoxId(r, c);
        return numsInRows[r][d] + numsInColumns[c][d] + numsInBoxes[idx][d] == 0;
    }

    // Place a number in a given cell in the board.
    public void addNumberToCell(int d, int r, int c) {
        int idx = getBoxId(r, c);
        numsInRows[r][d]++;
        numsInColumns[c][d]++;
        numsInBoxes[idx][d]++;
        board[r][c] = d;
    }

    // Remove a number from the given cell in the board
    public void deleteNumberFromCell(int d, int r, int c) {
        int idx = getBoxId(r, c);
        numsInRows[r][d]--;
        numsInColumns[c][d]--;
        numsInBoxes[idx][d]--;
        board[r][c] = 0;
    }

    public void addNextNumbers(int r, int c) {
        // When the last cell is reached then sudoku is solved.
        if ((c == boardSize - 1) && (r == boardSize - 1)) {
            sudokuSolved = true;
        }
        else {
            // If we are at the last column of a row,
            // then continue to the next row, first column.
            if (c == boardSize - 1) {
                backtrack(r + 1, 0);
            }
            // Go to the next column
            else {
                backtrack(r, c + 1);
            }
        }
    }

    public void backtrack(int r, int c) {
        if (board[r][c] == 0) {
            // Try to place numbers 1 to 9 in every empty cell.
            for (int d = 1; d < 10; d++) {
                if (couldBePlacedInCell(d, r, c)) {
                    addNumberToCell(d, r, c);
                    addNextNumbers(r, c);
                    // If sudoku is not solved with given number in a cell,
                    // then remove the number from the cell.
                    if (!sudokuSolved) {
                        deleteNumberFromCell(d, r, c);
                    }
                }
            }
        }
        else {
            addNextNumbers(r, c);
        }
    }

    // Initialize the rows, columns and boxes arrays.
    public void initBoard() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                int num = board[i][j];
                if (num != 0) {
                    addNumberToCell(num, i, j);
                }
            }
        }
    }

    public int[][] solveSudoku(int[][] board) {
        this.board = board;
        initBoard();
        backtrack(0, 0);
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

        SudokuSolverApple ssA = new SudokuSolverApple();
        int[][] board1Output = ssA.solveSudoku(board1Input);
        System.out.println(assertTrueSudokuSolverResult(board1Output, expectedBoard1Output));
    }

    private static boolean assertTrueSudokuSolverResult(int[][] b1, int[][] b2) {
        for(int r = 0 ; r < 9; r++) {
            for (int c = 0 ; c < 9; c++) {
                if(b1[r][c] != b2[r][c]) {
                    return false;
                }
                System.out.print(b1[r][c] + " ");
            }
            System.out.println();
        }
        return true;
    }
}
