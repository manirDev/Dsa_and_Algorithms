package LeetCodeCards.Graph.Bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ShortestPathBinaryMatrix {
    public static void main(String[] args) {
        int[][] grid = {{1,0,0},{1,1,0},{1,1,0}};
        int res = shortestPathHelper(grid);
        System.out.println(res);
    }

    private static int shortestPathHelper(int[][] grid) {
        if (grid[0][0] == 1 || grid[grid.length - 1][grid[0].length - 1] == 1) {
            return -1;
        }
        int[][] res = new int[grid.length][grid[0].length];
        Queue<Integer[]> bfsQueue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        bfsQueue.add(new Integer[]{0, 0});
        visited.add("0,0");
        int[] rowDirs = {0, 1, 0, -1, 1, -1, 1, -1};
        int[] colDirs = {1, 0, -1, 0, 1, -1, -1, 1};
        while(!bfsQueue.isEmpty()){
            int currRow = bfsQueue.peek()[0];
            int currCol = bfsQueue.peek()[1];
            if (currRow == grid.length - 1 && currCol == grid[currRow].length - 1){
                return res[currRow][currCol]  + 1;
            }
            bfsQueue.remove();
            for (int i=0; i<8; i++){
                int adjRow = currRow + rowDirs[i];
                int adjCol = currCol + colDirs[i];
                if (isValidCell(grid, adjRow, adjCol, visited)){
                    res[adjRow][adjCol] = res[currRow][currCol] + 1;
                    bfsQueue.add(new Integer[]{adjRow, adjCol});
                    visited.add(adjRow + "," + adjCol);
                }
            }
        }
        return -1;
    }
    private static boolean isValidCell(int[][] grid, int adjRow, int adjCol, Set<String> visited) {
        boolean rowInBounds = adjRow >= 0 && adjRow < grid.length;
        boolean colInBounds = adjCol >= 0 && adjCol < grid[0].length;

        if (!rowInBounds || !colInBounds || visited.contains(adjRow + "," + adjCol)  || grid[adjRow][adjCol] == 1){
            return false;
        }
        return true;
    }
}
