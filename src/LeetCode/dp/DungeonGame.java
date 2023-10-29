package LeetCode.dp;

import java.util.Arrays;

public class DungeonGame {
    public static void main(String[] args) {
        int[][] dungeon = {
                            {-2,-3,3},
                            {-5,-10,1},
                            {10,30,-5}
                        };

//        for (int i=0; i<dungeon.length; i++){
//            for (int j=0; j<dungeon[i].length; j++){
//                if (dungeon[i][j] > 0){
//                    dungeon[i][j] = dungeon[i][j] * -1;
//                }
//            }
//        }
        for (int[] row : dungeon){
            System.out.println(Arrays.toString(row));
        }
        int[][] dp = new int[dungeon.length][dungeon[0].length];
        for (int[] row : dp){
            Arrays.fill(row, -1);
        }
        int res = dungeonHelper(dungeon, 0, 0, dp);
        if (res == 0 && dungeon[0][0] < 0){
            res = dungeon[0][0];
        }
        if (res >= 0){
            System.out.println(1);
        }
        else{
            System.out.println(Math.abs(res) + 1);
        }
    }

    private static int dungeonHelper(int[][] dungeon, int row, int col, int[][] dp) {
        if (row >= dungeon.length || col >= dungeon[0].length){
            return Integer.MIN_VALUE;
        }
        if (row == dungeon.length - 1 && col == dungeon[0].length - 1){
            return Math.min(dungeon[row][col], 0);
        }
        if (dp[row][col] != -1){
            return dp[row][col];
        }
        int right = dungeonHelper(dungeon, row, col + 1, dp);
        int down = dungeonHelper(dungeon, row + 1, col, dp);
        int tempRes = dungeon[row][col] +  Math.max(right, down);
        return dp[row][col] = Math.min(tempRes, 0);
    }
}
