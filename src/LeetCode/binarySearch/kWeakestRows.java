package LeetCode.binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class kWeakestRows {
    public static void main(String[] args) {
        int[][] mat = {
                {1,1,0,0,0},
                {1,1,1,1,0},
                {1,0,0,0,0},
                {1,1,0,0,0},
                {1,1,1,1,1}
            };
        int k = 3;
        int row = mat.length;
        int col = mat[0].length;
        int[] res = helper(mat, k, row, col);
        System.out.println(Arrays.toString(res));
    }

    private static int[] helper(int[][] mat, int k, int r, int c) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i<r; i++){
            int start = 0;
            int end = c - 1;
            while (start <= end){
                int mid = start + (end - start);
                if (mat[i][mid] == 1){
                    start = mid + 1;
                }
                else if (mat[i][mid]  == 0){
                    end = mid - 1;
                }
            }
            //after we want to get the indexes
            list.add(start * r + i);
        }
        Collections.sort(list);
        int[] res = new int[k];
        for (int i=0; i<k; i++){
            res[i] = list.get(i) % r;
        }
        return res;
    }
}
