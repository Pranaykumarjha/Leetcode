import java.util.*;

class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int count = 0;

        int[][] directions = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        };

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == '1') {
                    count++;  // found a new island

                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    grid[i][j] = '0';  // mark visited

                    // BFS to remove entire island
                    while (!queue.isEmpty()) {
                        int[] current = queue.poll();
                        int r = current[0];
                        int c = current[1];

                        for (int[] d : directions) {
                            int nr = r + d[0];
                            int nc = c + d[1];

                            if (nr >= 0 && nr < rows &&
                                nc >= 0 && nc < cols &&
                                grid[nr][nc] == '1') {

                                grid[nr][nc] = '0'; // mark visited
                                queue.offer(new int[]{nr, nc});
                            }
                        }
                    }
                }
            }
        }

        return count;
    }
}