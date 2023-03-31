package blind75.backtracking;

public class CountWordOccurrenceIn2DGrid {

    public int countWordOccurrence(char[][] board, String word) {
        int count = 0;
        int wordLength = word.length();
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                // search vertically
                StringBuilder temp = new StringBuilder();
                for (int k = r; k < board.length && k < r + wordLength; k++) {
                    temp.append(String.valueOf(board[k][c]));
                }
                if (temp.toString().equals(word)) {
                    count++;
                }

                // search horizontally
                temp.setLength(0);
                for (int k = c; k < board[r].length && k < c + wordLength; k++) {
                    temp.append(String.valueOf(board[r][k]));
                }
                if (temp.toString().equals(word)) {
                    count++;
                }

                // search forward-down diagonal
                temp.setLength(0);
                for (int    r1 = r, c1 = c;
                            r1 < board.length &&
                            r1 < r + wordLength &&
                            c1 < board[r1].length &&
                            c1 < c + wordLength;
                            r1++, c1++) {

                    temp.append(String.valueOf(board[r1][c1]));
                }
                if (temp.toString().equals(word)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        char[][] grid = { {'B', 'N', 'E', 'Y', 'S'},
            {'H', 'E', 'D', 'E', 'S'},
            {'S', 'G', 'N', 'D', 'E'}};
        CountWordOccurrenceIn2DGrid c = new CountWordOccurrenceIn2DGrid();
        System.out.println(c.countWordOccurrence(grid, "DES"));
    }
}
