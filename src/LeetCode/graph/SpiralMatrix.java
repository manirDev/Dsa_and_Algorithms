package LeetCode.graph;

import java.awt.*;
import java.util.*;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] grid = {
                    {1,2,3},
                    {4,5,6},
                    {7,8,9},
                };

        List<Integer> res = new ArrayList<>();
        spiralHelper(grid, 0, 0, res, 'R', new boolean[grid.length][grid[0].length]);
        System.out.println(res);
    }

    private static void spiralHelper(int[][] grid, int row, int col, List<Integer> res, char dir, boolean[][] visited) {
        boolean rowInBounds = row >= 0 && row < grid.length;
        boolean colInBounds = col >= 0 && col < grid[0].length;
        if (!rowInBounds || !colInBounds || visited[row][col]){
            return;
        }
        res.add(grid[row][col]);
        visited[row][col] = true;
        if (dir == 'R') {
            spiralHelper(grid, row, col + 1, res, dir, visited);
            dir = 'D';
        }
        if (dir == 'D'){
            spiralHelper(grid, row + 1, col, res, dir, visited);
            dir = 'L';
        }
        if (dir == 'L'){
            spiralHelper(grid, row, col - 1, res, dir,visited);
            dir = 'U';
        }
        if (dir == 'U'){
            spiralHelper(grid, row - 1, col, res, dir, visited);
            dir = 'R';
            spiralHelper(grid, row, col + 1, res, dir, visited);
        }
    }
}
