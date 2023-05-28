package Leetcodes;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
        int numRows = 5;
        System.out.println(generate(numRows));
    }
    private static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) {
            return res;
        }
        for(int i=1;i<=numRows;i++){
            List<Integer> row = new ArrayList();
            for(int j=0;j<i;j++) {
                if(j==0 || j == i-1){
                    row.add(1);
                }
                else {
                    int sum = res.get(i-2).get(j-1) + res.get(i-2).get(j);
                    row.add(sum);
                }
            }
            res.add(row);

        }
        return res;
    }
}
