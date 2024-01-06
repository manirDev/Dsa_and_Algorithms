package LeetCode.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PascalTriangleII {

    public static void main(String[] args) {
        int rowIndex = 3;
        HashMap<List<Integer>, Integer> memo = new HashMap<>();
        List<Integer> res =  new ArrayList<>();
        for (int col=0; col <=rowIndex; col++){
            res.add(getRowHelper(rowIndex, col, memo));
        }
        System.out.println(res);
    }

    private static int getRowHelper(int row, int col, HashMap<List<Integer>, Integer> memo) {
        if (row == 0 || col == 0 || row == col){
            return 1;
        }
        if(memo.containsKey(Arrays.asList(row,col))){
            return memo.get(Arrays.asList(row,col));
        }

        int sum = getRowHelper(row - 1, col - 1, memo) + getRowHelper(row - 1, col, memo);
        memo.putIfAbsent(Arrays.asList(row, col), sum);
        return sum;
    }
}
