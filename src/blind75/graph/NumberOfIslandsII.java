package blind75.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfIslandsII {

    public void dfs(char[][] grid, int r, int c, boolean[][] visited) {

        int nr = grid.length;
        int nc = grid[0].length;

        if(r < 0 || c < 0 || r >= nr || c >= nc || visited[r][c]) return;

        // mark the cell as visited.
        visited[r][c] = true;
        // search all four directions from the cell [r, c]
        dfs(grid,r - 1, c, visited);
        dfs(grid, r + 1, c, visited);
        dfs(grid, r, c - 1, visited);
        dfs(grid, r, c + 1, visited);
    }
    public int numIslands(char[][] grid) {
        int nr = grid.length;
        int nc = grid[0].length;
        int nIslands = 0;

        boolean[][] visited = new boolean[nr][nc];
        // init the visited[][] with false
        for(boolean[] row : visited) {
            Arrays.fill(row, false);
        }

        for (int r = 0 ; r < nr; r++) {
            for(int c = 0; c < nc; c++) {
                if(grid[r][c] == '1') {
                    dfs(grid, r, c, visited);
                    ++nIslands;
                }
            }
        }
        return nIslands;
    }
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> ans = new ArrayList<>();
        char[][] grid = new char[m][n];
        // initialize every cell with '0'
        for(char[] row : grid) {
            Arrays.fill(row, '0');
        }

        for(int[] p : positions) {
            int r = p[0];
            int c = p[1];
            grid[r][c] = '1';
            int nIslands = numIslands(grid);
            ans.add(nIslands);
        }
        return ans;
    }
}
