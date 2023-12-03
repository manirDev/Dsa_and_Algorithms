package LeetCode.graph;

import java.util.*;

public class MinimumObstacleRemoval {
    public static void main(String[] args) {
        int[][] grid = {
                {0,1,1},
                {1,1,0},
                {1,1,0},
            };
        int[][] ans = new int[grid.length][grid[0].length];
        for (int[] row : ans){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        int res = minimumObstaclesHelper(grid, 0, 0, ans);
        System.out.println(res);
        int dfsRes = minimumObstaclesDfsHelper(grid, 0, 0, new HashSet<>());
        System.out.println(dfsRes);
    }

    private static int minimumObstaclesDfsHelper(int[][] grid, int row, int col, Set<String> visited) {
        boolean rowInBounds = row >= 0 && row < grid.length;
        boolean colInBounds = col >= 0 && col < grid[0].length;
        if (!rowInBounds || !colInBounds || visited.contains(row + "" + col)){
            return 0;
        }
        visited.add(row + "" + col);
        if (row == grid.length - 1 && col == grid[0].length - 1){
            return grid[grid.length - 1][grid[0].length - 1];
        }
        int left = 0;
        int right = 0;
        int up = 0;
        int down = 0;
        if (col + 1 < grid[0].length){
            right = grid[row][col + 1] + minimumObstaclesDfsHelper(grid, row, col + 1, visited);
        }
        if (col - 1 >= 0){
            left = grid[row][col - 1] + minimumObstaclesDfsHelper(grid, row, col - 1, visited);
        }
        if (row + 1 < grid.length){
            down = grid[row + 1][col] + minimumObstaclesDfsHelper(grid, row + 1, col, visited);
        }
        if (row - 1 >= 0){
            up = grid[row - 1][col] + minimumObstaclesDfsHelper(grid, row - 1, col, visited);
        }
        int res = Math.min(Math.min(right, left), Math.min(up, down));
        return res;
    }

    private static int minimumObstaclesHelper(int[][] grid, int row, int col, int[][] ans) {
        Queue<Integer[]> bfsQueue = new LinkedList<>();
        bfsQueue.add(new Integer[]{row, col});
        ans[row][col] = 0;
        int[] dirRows = {0, 1, 0, -1};
        int[] dirCols = {-1, 0, 1, 0};
        while (!bfsQueue.isEmpty()){
            int currRow = bfsQueue.peek()[0];
            int currCol = bfsQueue.peek()[1];
            bfsQueue.remove();
            for (int i=0; i<4; i++){
                int adjRow = currRow + dirRows[i];
                int adjCol = currCol + dirCols[i];
                if (isValidCell(grid, adjRow, adjCol)){
                    if (grid[adjRow][adjCol] == 1){
                        if (ans[currRow][currCol] + 1 < ans[adjRow][adjCol]){
                            ans[adjRow][adjCol] = ans[currRow][currCol] + 1;
                            bfsQueue.add(new Integer[]{adjRow, adjCol});
                        }
                    }
                    if (grid[adjRow][adjCol] == 0){
                        if (ans[currRow][currCol] < ans[adjRow][adjCol]){
                            ans[adjRow][adjCol] = ans[currRow][currCol];
                            bfsQueue.add(new Integer[]{adjRow, adjCol});
                        }
                    }
                }
            }
        }
        return ans[ans.length - 1][ans[0].length - 1];
    }

    private static boolean isValidCell(int[][] grid, int adjRow, int adjCol) {
        boolean rowInBounds = adjRow >= 0 && adjRow < grid.length;
        boolean colInBounds = adjCol >= 0 && adjCol < grid[0].length;
        if (!rowInBounds || !colInBounds){
            return false;
        }
        return true;
    }
    private static boolean isValidPrevCell(int[][] grid, int adjRow, int adjCol) {
        boolean rowInBounds = adjRow >= 0 && adjRow < grid.length;
        boolean colInBounds = adjCol >= 0 && adjCol < grid[0].length;
        if (!rowInBounds || !colInBounds){
            return false;
        }
        return true;
    }

}
