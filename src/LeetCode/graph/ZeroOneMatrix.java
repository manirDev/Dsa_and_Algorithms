package LeetCode.graph;

import java.util.*;

public class ZeroOneMatrix {
    public static void main(String[] args) {
        int[][] grid = {
                {0,0,0},
                {0,1,0},
                {1,1,1}
        };
        updateMatrixHelper(grid);
        for (int[] row : grid){
            System.out.println(Arrays.toString(row));
        }
    }

    private static void updateMatrixHelper(int[][] grid) {
        Queue<Integer[]> bfsQueue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid[i].length; j++){
                if (grid[i][j] == 0){
                    bfsQueue.add(new Integer[]{i, j});
                    visited.add(i + "" + j);
                }
            }
        }
        int[] dirRows = {-1,0,1,0};
        int[] dirCols = {0,1,0,-1};
        while (!bfsQueue.isEmpty()){
            int row = bfsQueue.peek()[0];
            int col = bfsQueue.peek()[1];
            bfsQueue.remove();
            for (int i=0; i<4; i++){
                int adjRow = row + dirRows[i];
                int adjCol = col + dirCols[i];
                if (isValidCell(grid, adjRow, adjCol, visited)){
                    grid[adjRow][adjCol] = grid[row][col] + 1;
                    bfsQueue.add(new Integer[]{adjRow, adjCol});
                    visited.add(adjRow + "" + adjCol);
                }
            }
        }
    }
    private static boolean isValidCell(int[][] grid, int adjRow, int adjCol, Set<String> visited) {
        boolean rowInBounds = adjRow >= 0 && adjRow < grid.length;
        boolean colInBounds = adjCol >= 0 && adjCol < grid[0].length;
        if (!rowInBounds || !colInBounds || visited.contains(adjRow + "" + adjCol)){
            return false;
        }
        return true;
    }
}
