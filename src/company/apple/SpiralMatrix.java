package company.apple;

public class SpiralMatrix {

    public int[][] generateMatrix(int n) {

        if (n < 1) {
            return new int[0][0];
        }

        int[][] result = new int[n][n];
        int col_start = 0;
        int col_end = n - 1;
        int row_start = 0;
        int row_end = n - 1;

        int element = 1;

        while (col_start <= col_end && row_start <= row_end) {
            // move right
            for(int c = col_start; c <= col_end; c++) {
                result[row_start][c] = element;
                element++;
            }
            // move down
            for(int r = row_start + 1; r <= row_end; r++) {
                result[r][col_end] = element;
                element++;
            }
            // move left
            if(row_start != row_end) {
                for (int c = col_end - 1; c >= col_start; c--) {
                    result[row_end][c] = element;
                    element++;
                }
            }
            // move up
            if(col_start != col_end) {
                for (int r = row_end - 1; r > row_start; r--) {
                    result[r][col_start] = element;
                    element++;
                }
            }
            // increment/decrement indexes
            row_start++;
            col_start++;
            row_end--;
            col_end--;
        }
        return result;
    }
}
