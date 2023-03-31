package blind75.graph;

import javax.swing.*;
import javax.xml.crypto.dsig.spec.XPathFilterParameterSpec;
import java.util.*;

public class PacificAtlanticWaterFlow {
    // Time = O(RxC)
    // Space =
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if(heights == null || heights.length == 0) return result;

        int nr = heights.length;
        int nc = heights[0].length;
        // if there is only one row, then return that row.
        Set<List<Integer>> pacific = new HashSet<>();
        Set<List<Integer>> atlantic = new HashSet<>();

        // first and last row flow the pacific and the atlantic ocean, so we should start searching from them in words.
        for(int c = 0 ; c < nc; c++) {
            dfs(0, c, nr, nc, heights, heights[0][c], pacific);
            dfs(nr - 1, c, nr, nc, heights, heights[nr - 1][c], atlantic);
        }

        for(int r = 0 ; r < nr; r++) {
            dfs(r, 0, nr, nc, heights, heights[r][0], pacific);
            dfs(r, nc - 1, nr, nc, heights, heights[r][nc - 1], atlantic);
        }

        // for each cell in the grid, if it's in both of the visited sets, then we should add it to the result.

        for (int r = 0 ; r < nr; r++) {
            for (int c = 0 ; c < nc; c++) {
                List<Integer> currentCell = new ArrayList<>(Arrays.asList(r, c));
                if(pacific.contains(currentCell) && atlantic.contains(currentCell)) {
                    result.add(currentCell);
                }
            }
        }
        return result;
    }

    private void dfs(int r, int c, int nr, int nc,  int[][] heights, int previousH, Set<List<Integer>> visited) {
        //base case
        List<Integer> currentP = new ArrayList<>(Arrays.asList(r, c));
        if(r < 0 || r >= nr || c < 0 || c >= nc || previousH > heights[r][c] || visited.contains(currentP))
            return;

        visited.add(currentP);
        dfs(r + 1, c, nr, nc, heights, heights[r][c], visited);
        dfs(r - 1, c, nr, nc, heights, heights[r][c], visited);
        dfs(r, c + 1, nr, nc, heights, heights[r][c], visited);
        dfs(r, c - 1 , nr, nc, heights, heights[r][c], visited);
        return;
    }
}
