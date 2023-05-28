package Leetcodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Triangle {
    public static void main(String[] args) {
        int[][] triangle = {
                            {2},
                            {3,4},
                            {6,5,7},
                            {4,1,8,3}
                            };
        List<List<Integer>> list = new ArrayList<>();
        for (int[] row: triangle) {
            list.add(new ArrayList(Arrays.asList(row)));
        }
        //System.out.println(minimumTotal(list));
        minimumTotal(list);
    }
    private static void minimumTotal(List<List<Integer>> triangle) {
        for (List<Integer> list: triangle) {
            for (int i=0; i<list.size(); i++){
                System.out.println();
            }
        }

    }
}
