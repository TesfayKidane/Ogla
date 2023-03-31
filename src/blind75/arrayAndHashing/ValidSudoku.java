package blind75.arrayAndHashing;

import java.util.*;

public class ValidSudoku {

    class Key {
        int r;
        int c;
        public Key(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
           if(this == o) return true;
           if(o == null || this.getClass() != o.getClass()) return false;
           Key key = (Key) o;
           return key.r == this.r && key.c == this.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, c);
        }
    }
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> columns = new HashMap<>();
        Map<Key, Set<Character>> threeByThreeBox = new HashMap<>();

        for(int i = 0 ; i < 9; i++) {
            rows.put(i, new HashSet<>());
            columns.put(i, new HashSet<>());
        }

        for(int r = 0; r < 9; r++) { // board is indexed 0 to 8 and should contain 1 to 9 in each row.
            for(int c = 0; c < 9; c++) { // / board is indexed 0 to 8 and should contain 1 to 9 in each column.
                if(board[r][c] == '.') continue;
                Key key = new Key(r/3, c/3);
                threeByThreeBox.putIfAbsent(key, new HashSet<>());

                if(rows.get(r).contains(board[r][c]) || // return false if column set have duplicate number
                   columns.get(c).contains(board[r][c]) || // // return false if column set have duplicate number
                   threeByThreeBox.get(key).contains(board[r][c]) // return false if the 3by3 cell contains duplicate number
                ) {
                    return false;
                }

                rows.get(r).add(board[r][c]);
                columns.get(c).add(board[r][c]);
                threeByThreeBox.get(key).add(board[r][c]);
            }
        }
        return false;
    }

    public boolean isValidSudoku2(char[][] board) {
        int N = 9;
        HashSet<Character>[] rows = new HashSet[N];
        HashSet<Character>[] columns = new HashSet[N];
        HashSet<Character>[] boxes = new HashSet[N];

        // Initialize
        for(int i = 0 ; i < N; i++) {
            rows[i] = new HashSet<>();
            columns[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for(int r = 0 ; r < N; r++) {
            for(int c = 0; c < N; c++) {
                if(board[r][c] == '.')
                    continue;
                int boxKey = (r/3)*3 + c/3;
                if(rows[r].contains(board[r][c]) ||
                columns[c].contains(board[r][c]) ||
                boxes[boxKey].contains(board[r][c]))
                {
                    return false;
                }

                rows[r].add(board[r][c]);
                columns[c].add(board[r][c]);
                boxes[boxKey].add(board[r][c]);
            }
        }
        return true;
    }
}
