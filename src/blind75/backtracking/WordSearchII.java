package blind75.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordSearchII {

    /**
     * NOTE: This solution is time exceeding according to leetcode. A more efficient solution could be achived by using
     * Trie (Prefix Tree) and backtracking.
     *
     * Time : O(W * M * N * 4^MN) where W is number of words, M * N is the dimesion of the board.
     * Space: O(MN)
     * @param board
     * @param words
     * @return
     */
    public List<String> findWords(char[][] board, String[] words) {
        // starting from each cell, search horizontally, vertically and diagonally.
        if(board == null || board.length == 0 || board[0].length == 0 || words.length == 0)
            return new ArrayList<>();
        List<String> result = new ArrayList<>();
        for(String w : words) {
            if(!result.contains(w)) {
                if(exists(board, w)) {
                    result.add(w);
                }
            }
        }
        return result;
    }

    private boolean exists(char[][] board, String w) {
        int nr = board.length;
        int nc = board[0].length;
        boolean[][] visited = new boolean[nr][nc];
        for (boolean[] row : visited) {
            Arrays.fill(row, false);
        }

        for(int r = 0 ; r < nr; r++) {
            for (int c = 0 ; c < nc; c++) {
                if (dfs(board, w, 0, r, c,visited )) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String w, int currentWordI, int r, int c, boolean[][] visited) {
        // base case.
        if(currentWordI == w.length()) {
            return true;
        }
        int nr = board.length;
        int nc = board[0].length;
        if(r < 0 || c < 0 || r >= nr || c >= nc || visited[r][c] || board[r][c] != w.charAt(currentWordI)) {
            return false;
        }

        visited[r][c] = true;
        boolean result = dfs(board, w, currentWordI + 1, r+1, c, visited) ||
                dfs(board, w, currentWordI + 1, r - 1, c, visited) ||
                dfs(board, w, currentWordI + 1, r, c + 1, visited) ||
                dfs(board, w, currentWordI + 1, r, c - 1, visited);
        visited[r][c] = false;
        return result;

    }

    public static void main(String[] args) {
        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] tWords = {"oath","pea","eat","rain"};
        WordSearchII ws = new WordSearchII();
        ws.findWords(board, tWords);
    }
}
