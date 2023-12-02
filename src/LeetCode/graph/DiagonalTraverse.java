package LeetCode.graph;

import java.util.*;

public class DiagonalTraverse {
    public static void main(String[] args) {
        int[][] grid = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        List<Integer> res = new ArrayList<>();
        diagonalTraverseHelper(grid, 0, 0, res, new HashSet<>());
        int[] arr = new int[grid.length*grid[0].length];
        for (int i=0; i<res.size(); i++){
            arr[i] = res.get(i);
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void diagonalTraverseHelper(int[][] grid, int row, int col, List<Integer> res, Set<String> visited) {
        boolean rowInBounds = row >= 0 && row < grid.length;
        boolean colInBounds = col >= 0 && col < grid[0].length;
        if (!rowInBounds || !colInBounds || visited.contains(row + "" + col)){
            return;
        }
        visited.add(row + "" + col);
        res.add(grid[row][col]);

        if (row - 1 >= 0 && col + 1 < grid[0].length){
            diagonalTraverseHelper(grid, row - 1, col + 1, res, visited);
        }
        if (row + 1 < grid.length && col - 1 >=0){
            diagonalTraverseHelper(grid, row + 1, col - 1, res, visited);
        }
        if (row - 1 < 0 && col + 1 < grid[0].length){
            diagonalTraverseHelper(grid, row, col + 1, res, visited);
        }
        if (row - 1 < 0 || col + 1 >= grid[0].length){
            diagonalTraverseHelper(grid, row + 1, col, res, visited);
        }
        if (row + 1 < grid.length || col - 1 < 0){
            diagonalTraverseHelper(grid, row + 1, col, res, visited);
        }
        if (row + 1 >= grid.length || col - 1 >= 0){
            diagonalTraverseHelper(grid, row, col + 1, res,visited);
        }
    }
}
