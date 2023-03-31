package blind75.graph;

import java.util.Arrays;

public class TheMaze {
    // 490. The Maze.
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {

        int nr = maze.length;
        int nc = maze[0].length;

        boolean[][] visited = new boolean[nr][nc];
        for(boolean[] row : visited) {
            Arrays.fill(row, false);
        }

        for(int r = start[0]; r < nr - 1; r++) {
            for(int c = start[1]; c < nc - 1; c++) {
                if(!dfs(maze, destination, visited, r, c, nr, nc))
                    return false;
            }
        }
        return true;
    }

    private boolean dfs(int[][] maze, int[] destination, boolean[][] visited, int r, int c, int nr, int nc ) {

        if(r < 0 || r > nr - 1 || c < 0 || c > nc - 1 || visited[r][c] || maze[r][c] == 1) {
            return false;
        }

        if(r == destination[0] && c == destination[1]) {
            return true;
        }

        visited[r][c] = true;

        boolean result = dfs(maze, destination, visited, r + 1, c, nr, nc) ||
                dfs(maze, destination, visited, r - 1, c, nr, nc) ||
                dfs(maze, destination, visited, r, c + 1, nr, nc) ||
                dfs(maze, destination, visited, r, c - 1, nr, nc);
        visited[r][c] = false;
        return result;
    }
}
