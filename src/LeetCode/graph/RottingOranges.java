package LeetCode.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class RottingOranges {
    public static void main(String[] args) {
        int[][] grid = {
                {2,1,1},
                {1,1,0},
                {0,1,1},
        };
        int res = orangesRottingHelper(grid);
        System.out.println(res);
    }

    private static int orangesRottingHelper(int[][] grid) {
        Queue<Integer[]> bfsQueue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        int[] dirRows = {1, 0, -1, 0};
        int[] dirCols = {0, 1, 0, -1};
        int res = 0, notRotten = 0;
        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid[0].length; j++){
                if (grid[i][j] == 2){
                    bfsQueue.add(new Integer[]{i, j, 0});
                    visited.add(i + "" + j);
                }
                if (grid[i][j] == 1){
                    notRotten++;
                }
            }
        }

        while (!bfsQueue.isEmpty()){
            int currRow = bfsQueue.peek()[0];
            int currCol = bfsQueue.peek()[1];
            int currTime = bfsQueue.peek()[2];
            res = Math.max(res, currTime);
            bfsQueue.remove();
            for (int i=0; i<4; i++){
                int adjRow = currRow + dirRows[i];
                int adjCol = currCol + dirCols[i];
                if (isValidCell(grid, adjRow, adjCol, visited)){
                    if (grid[currRow][currCol] == 2 && grid[adjRow][adjCol] == 1){
                        notRotten--;
                        grid[adjRow][adjCol] = 2;
                        bfsQueue.add(new Integer[]{adjRow, adjCol, currTime + 1});
                        visited.add(adjRow + "" + adjCol);
                    }
                }
            }
        }

        return notRotten == 0 ? res : -1;
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
