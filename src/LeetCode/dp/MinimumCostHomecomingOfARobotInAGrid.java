package LeetCode.dp;

import java.util.Arrays;

public class MinimumCostHomecomingOfARobotInAGrid {
    static  int result = Integer.MAX_VALUE;
    public static void main(String[] args) {
        int[] startPos = {1, 0};
        int[] homePos = {2, 3};
        int[] rowCosts = {5, 4, 3};
        int[] colCosts = {8, 2, 6, 7};
        int[][] memo = new int[rowCosts.length][colCosts.length];
        for (int[] row : memo){
            Arrays.fill(row, -1);
        }
        int res = minCostHelper(rowCosts, colCosts, startPos[0], startPos[1], homePos[0], homePos[1], memo);
        System.out.println(res);
    }

    private static int minCostHelper(int[] rowCosts, int[] colCosts, int sr, int sc, int hr, int hc, int[][] memo) {
        boolean rowInBounds = sr >= 0 && sr < rowCosts.length;
        boolean colInBounds = sc >= 0 && sc < colCosts.length;
        if (!rowInBounds || !colInBounds){
            return 0;
        }
        if (memo[sr][sc] != -1){
            return memo[sr][sc];
        }
        int left = 0;
        int right = 0;
        int up = 0;
        int down = 0;
        if (sc + 1 <= hc){
            right = colCosts[sc + 1] + minCostHelper(rowCosts, colCosts, sr, sc + 1, hr, hc, memo);
        }
        if (sc - 1 >= 0){
            left = colCosts[sc - 1] + minCostHelper(rowCosts, colCosts, sr, sc - 1, hr, hc, memo);
        }
        if (sr + 1 <= hr){
            down = rowCosts[sr + 1] + minCostHelper(rowCosts, colCosts, sr + 1, sc, hr, hc, memo);
        }
        if (sr - 1 >= 0){
            up = rowCosts[sr - 1] + minCostHelper(rowCosts, colCosts, sr - 1, sc, hr, hc, memo);
        }
        result = Math.min(result, Math.min(Math.min(left, right), Math.min(down, up)));
        memo[sr][sc] = result;
        return memo[sr][sc];
    }
}
