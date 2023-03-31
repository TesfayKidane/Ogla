package blind75.backtracking;

import java.util.Arrays;

public class WordSearchI {

    public int exist(char[][] board, String word) {
        int nr = board.length;
        int nc = board[0].length;

        boolean path[][] = new boolean[nr][nc];
        for(boolean[] row : path) {
            Arrays.fill(row, false);
        }
        int count = 0;
        for(int r = 0; r < nr; r++) {
            for(int c = 0 ; c < nc; c++) {
                if(dfs(board, word, r, c, 0, path)) {
                    return count;
                }
            }
        }
        return count;
    }

    private boolean dfs(char[][] board, String word, int r, int c, int i, boolean[][] path) {
        int nr = board.length;
        int nc = board[0].length;

        if (i == word.length()) return true;

        if(r < 0 || c < 0 || r >= nr || c >= nc || word.charAt(i) != board[r][c] || path[r][c])
            return false;

        path[r][c] = true;
        boolean result =
                dfs(board, word, r + 1, c,     i + 1, path) ||
                dfs(board, word, r - 1, c,     i + 1, path) ||
                dfs(board, word,    r,  c + 1, i + 1, path) ||
                dfs(board, word,    r,  c - 1, i + 1, path);
        path[r][c] = false;
        return result;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        };
        String tWords = "oath";
        WordSearchI ws = new WordSearchI();
        System.out.println(ws.exist(board, tWords));
    }
}
