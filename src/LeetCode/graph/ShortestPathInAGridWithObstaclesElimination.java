package LeetCode.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ShortestPathInAGridWithObstaclesElimination {
    public static void main(String[] args) {
        int[][] grid = {
                {0,1,1},
                {1,1,1},
                {1,0,0}
        };
        int k = 1;
        int[][] ans = new int[grid.length][grid[0].length];
        int res = shortestPathWithEliminationHelper(grid, 0, 0, ans, k);
        System.out.println(res);
    }

    private static int shortestPathWithEliminationHelper(int[][] grid, int row, int col, int[][] ans, int k) {
        Queue<Integer[]> bfsQueue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        bfsQueue.add(new Integer[]{row, col, k});
        visited.add(row + "" + col + "" + k);
        int[] dirRows = {-1,0,1,0};
        int[] dirCols = {0,1,0,-1};
        while (!bfsQueue.isEmpty()){
            int currRow = bfsQueue.peek()[0];
            int currCol = bfsQueue.peek()[1];
            int obs = bfsQueue.peek()[2];
            bfsQueue.remove();

            if (currRow == grid.length - 1 && currCol == grid[0].length - 1){
                return ans[currRow][currCol];
            }

            for (int i=0; i<4; i++){
                int adjRow = currRow + dirRows[i];
                int adjCol = currCol + dirCols[i];
                if(!isValidCell(grid, adjRow, adjCol)){
                    continue;
                }
                int currObs = 0;
                if(grid[adjRow][adjCol] == 1){
                    currObs = obs  - 1;
                }
                if(grid[adjRow][adjCol] == 0){
                    currObs = obs;
                }
                if(currObs >= 0 && !visited.contains(adjRow + "" + adjCol + "" + currObs)){
                    ans[adjRow][adjCol] = ans[currRow][currCol] + 1;
                    bfsQueue.add(new Integer[]{adjRow, adjCol, currObs});
                    visited.add(adjRow + "" + adjCol + "" + currObs);
                }
            }
        }
        return -1;
    }
    private static boolean isValidCell(int[][] grid, int adjRow, int adjCol) {
        boolean rowInBounds = adjRow >= 0 && adjRow < grid.length;
        boolean colInBounds = adjCol >= 0 && adjCol < grid[0].length;
        if (!rowInBounds || !colInBounds){
            return false;
        }
        return true;
    }
}
