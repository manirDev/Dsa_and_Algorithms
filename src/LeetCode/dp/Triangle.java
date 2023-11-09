package LeetCode.dp;

import LeetCode.linkedList.LinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {
    public static void main(String[] args) {
        List<List<Integer>>  triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3,4));
        triangle.add(Arrays.asList(6,5,7));
        triangle.add(Arrays.asList(4,1,8,3));
        Integer[][] memo = new Integer[triangle.size()][triangle.size()];
        int res = triangleMinPathSumHelper(triangle, 0, 0, memo);
        System.out.println(res);
    }

    private static int triangleMinPathSumHelper(List<List<Integer>> triangle, int row, int col, Integer[][] memo) {
        boolean rowInBounds = row < triangle.size();
        boolean colInBounds = col < triangle.size();
        if (!rowInBounds || !colInBounds){
            return 0;
        }
        if (memo[row][col] != null){
            return memo[row][col];
        }
        int down = triangle.get(row).get(col) + triangleMinPathSumHelper(triangle, row + 1, col, memo);
        int downRight = triangle.get(row).get(col) + triangleMinPathSumHelper(triangle, row + 1, col + 1, memo);
        int res = Math.min(down, downRight);
        memo[row][col] = res;
        return memo[row][col];
    }
}
