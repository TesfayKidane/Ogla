package blind75.backtracking;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Search word only in straight path [either horizontally, vertically or diagonally].
 */
public class WordSearchIII {

    public List<String> findWords(char[][] board, String[] words) {
        Set<String> result = new HashSet<>();
        Set<String> targetWords = new HashSet<>();
        int maxTword = 0;
        int minTword = Integer.MAX_VALUE;
        for (String w : words) {
            targetWords.add(w);
            maxTword = Math.max(maxTword, w.length());
            minTword = Math.min(minTword, w.length());
        }

        int nr = board.length;
        int nc = board[0].length;

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {

                // search vertically
                StringBuilder sb = new StringBuilder();
                for (int ri = r; ri < nr && r + minTword <= nr; ri++) {
                    sb.append(board[ri][c]);
                    if (targetWords.contains(sb.toString())) {
                        result.add(sb.toString());
                    }
                }

                // search horizontally
                StringBuilder sb1 = new StringBuilder();
                for (int ci = c; ci < nc && c + minTword <= nc; ci++) {
                    sb1.append(board[r][ci]);
                    if (targetWords.contains(sb1.toString())) {
                        result.add(sb1.toString());
                    }
                }

                // search diagonal
                StringBuilder sb3 = new StringBuilder();
                for (int ri = r, ci = c; ri < nr && ci < nc && r + minTword <= nr && c + minTword <= nc; ri++, ci++) {
                    sb3.append(board[ri][ci]);
                    if (targetWords.contains(sb1.toString())) {
                        result.add(sb1.toString());
                    }
                }
            }
        }
        return result.stream().collect(Collectors.toList());
    }

    void backtracking() {

    }

    public static void main(String[] args) {
       char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
       String[] tWords = {"oath","pea","eat","rain"};
       WordSearchIII ws = new WordSearchIII();
       ws.findWords(board, tWords);
    }
}
