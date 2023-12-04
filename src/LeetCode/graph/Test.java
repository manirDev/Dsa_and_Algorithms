package LeetCode.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Test {
    public static class QuadTuple {
        int row;
        int col;
        int val;
        int quota;

        public QuadTuple(int row, int col, int val, int quota) {
            this.row = row;
            this.col = col;
            this.val = val;
            this.quota = quota;
        }
    }

    public static int shortestPath(int[][] grid, int k) {
        Queue<QuadTuple> queue = new LinkedList<>();
        queue.add(new QuadTuple(0, 0, 0, k));
        int rowFinish = grid.length - 1;
        int colFinish = grid[0].length - 1;
        Set<String> visited = new HashSet<>();
        int[] dirRows = {-1, 0, 1, 0};
        int[] dirCols = {0, 1, 0, -1};
        while (!queue.isEmpty()) {
            QuadTuple current = queue.remove();
            int curRow = current.row;
            int curCol = current.col;
            int curVal = current.val;
            int curQuota = current.quota;
            if (curRow == rowFinish && curCol == colFinish) return curVal;
            for (int i=0; i<4; i++) {
                int adjRow = curRow + dirRows[i];
                int adjCol = curCol + dirCols[i];
                if (isValidCell(grid, adjRow, adjCol)) {
                    int tempQuota = 0;
                    if(grid[adjRow][adjCol] == 1){
                        tempQuota = curQuota  - 1;
                    }
                    if(grid[adjRow][adjCol] == 0){
                        tempQuota = curQuota;
                    }
                    if (tempQuota >= 0 && !visited.contains(adjRow + "," + adjCol + "," + tempQuota)) {
                        queue.add(new QuadTuple(adjRow, adjCol, curVal + 1, tempQuota));
                        visited.add(adjRow + "," + adjCol + "," + tempQuota);
                    }
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
    public static void main(String[] args) {
        int[][] grid = {{0, 0}, {1, 0}, {1, 0}, {1, 0}, {1, 0}, {1, 0}, {0, 0}, {0, 1}, {0, 1}, {0, 1}, {0, 0}, {1, 0}, {1, 0}, {0, 0}};
//        int[][] grid = {
//                {0,0,0},
//                {1,1,0},
//                {0,0,0},
//                {0,1,1},
//                {0,0,0}
//        };
        int k = 4;
        System.out.println(shortestPath(grid, k));

    }
}
