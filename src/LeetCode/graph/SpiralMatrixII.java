package LeetCode.graph;

import java.util.Arrays;

public class SpiralMatrixII {
    public static void main(String[] args) {
        int n = 3;
        int[][] grid = new int[n][n];
        spiralConstructHelper(grid, n, 0,0, 1, new boolean[n][n], 'R');
        for (int[] row : grid){
            System.out.println(Arrays.toString(row));
        }
    }

    private static void spiralConstructHelper(int[][] grid, int n, int i, int j, int idx,  boolean[][] visited, char dir) {
        boolean rowInBounds = i >= 0 && i < n;
        boolean colInBounds = j >= 0 && j < n;
        if (!rowInBounds || !colInBounds || idx > n*n || visited[i][j]){
            return;
        }
        grid[i][j] = idx;
        visited[i][j] = true;
        if (dir == 'R'){
            spiralConstructHelper(grid, n, i, j + 1, idx + 1, visited, dir);
            dir = 'D';
        }
        if (dir == 'D'){
            spiralConstructHelper(grid, n, i + 1, j, idx + 1, visited, dir);
            dir = 'L';
        }
        if (dir == 'L'){
            spiralConstructHelper(grid, n, i, j - 1, idx + 1, visited, dir);
            dir = 'U';
        }
        if (dir == 'U'){
            spiralConstructHelper(grid, n, i - 1, j, idx + 1, visited, dir);
            dir = 'R';
            spiralConstructHelper(grid, n, i, j + 1, idx + 1, visited, dir);
        }
    }
}
