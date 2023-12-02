package LeetCode.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ShortestPathToGetFood {
    public static void main(String[] args) {
        char[][] grid = {
                {'X','X','X','X','X','X'},
                {'X','*','O','O','O','X'},
                {'X','O','O','O','X','X'},
                {'X','X','#','X','X','X'}
        };

        int[][] res = new int[grid.length][grid[0].length];
        int row = 0, col = 0;
        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid[0].length; j++){
                if (grid[i][j] == '*'){
                    row = i;
                    col = j;
                    break;
                }
            }
        }
        res[row][col] = 0;
        int ans = shortestPathHelper(grid, row, col, res, new HashSet<>());
        System.out.println(ans);
    }

    private static int shortestPathHelper(char[][] grid, int row, int col, int[][] res, Set<String> visited) {
        Queue<Integer[]> bfsQueue = new LinkedList<>();
        bfsQueue.add(new Integer[]{row, col});
        visited.add(row + "" + col);
        int ansRow = 0, ansCol = 0;
        int[] dirRows = {0, 1, 0, -1};
        int[] dirCols = {1, 0, -1, 0};
        while (!bfsQueue.isEmpty()){
            int currRow = bfsQueue.peek()[0];
            int currCol = bfsQueue.peek()[1];
            bfsQueue.remove();
            for (int i=0; i<4; i++){
                int adjRow = currRow + dirRows[i];
                int adjCol = currCol + dirCols[i];
                if (isValidCell(grid, adjRow, adjCol, visited)){
                    res[adjRow][adjCol] = res[currRow][currCol] + 1;
                    bfsQueue.add(new Integer[]{adjRow, adjCol});
                    visited.add(adjRow + "" + adjCol);
                    if (grid[adjRow][adjCol] == '#'){
                        ansRow = adjRow;
                        ansCol = adjCol;
                        return res[ansRow][ansCol];
                    }
                }

            }
        }
        return -1;
    }

    private static boolean isValidCell(char[][] grid, int adjRow, int adjCol, Set<String> visited) {
        boolean rowInBounds = adjRow >= 0 && adjRow < grid.length;
        boolean colInBounds = adjCol >= 0 && adjCol < grid[0].length;
        if (!rowInBounds || !colInBounds || visited.contains(adjRow + "" + adjCol) || grid[adjRow][adjCol] == 'X'){
            return false;
        }
        return true;
    }
}
