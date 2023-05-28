package Leetcodes.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> result = new ArrayList<>();
        helper(result, matrix, m, n, 0, 0, 'R');
        for (int el:result) {
            System.out.println(el);
        }
    }

    private static void helper(List<Integer> list,  int[][] matrix, int m, int n, int r, int c, char d) {
        if (r==m || r<0 || c==n || c<0 || matrix[r][c]==101){
            return;
        }
        list.add(matrix[r][c]);
        matrix[r][c] = 101;
        if (d=='R'){
            helper(list, matrix, m, n, r, c+1, 'R');
            d ='D';
        }
        if (d=='D'){
            helper(list, matrix, m, n, r+1, c, 'D');
            d = 'L';
        }
        if (d=='L'){
            helper(list, matrix, m, n, r, c-1, 'L');
            d = 'T';
        }
        if (d=='T'){
            helper(list, matrix, m, n, r-1, c, 'T');
            d = 'R';
            helper(list, matrix, m, n, r, c+1, 'R');
        }
    }
}
