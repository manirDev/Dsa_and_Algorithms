package Leetcodes.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrixIIVII {
    public static void main(String[] args) {
        int n = 3;
        int[][] spiral = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        helper(visited, spiral, n, 0, 0, 1);
        for (int[] e:spiral){
            System.out.println(Arrays.toString(e));
        }
    }

    private static void helper(boolean[][] visited, int[][] matrix, int n, int r, int c, int val) {
        if (r==n || r<0 || c==n || c<0 || visited[r][c]){
            return;
        }
        visited[r][c] = true;
        matrix[r][c] = val;
        val++;
        if (c==0 || visited[r][c-1]){
            helper(visited, matrix, n, r-1, c, val);
        }
        if (c==n-1 || visited[r][c+1]){
            helper(visited, matrix, n, r+1, c, val);
        }

        helper(visited, matrix, n, r, c-1, val);
        helper(visited, matrix, n, r, c+1, val);

    }
}
