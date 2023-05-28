package Leetcodes.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrixII {
    public static void main(String[] args) {
        int n = 3;
        List<Integer> result = new ArrayList<>();
        int[][] matrix = createMatrix(n);
        int[][] spiral = new int[n][n];
        helper(result, matrix, n, 0, 0, 'R');

        for (int e:result) {
            System.out.print(" "+e);
        }
        System.out.println();
        int k = 0;
        for (int i=0;i<n; i++){
            for (int j=0; j<n; j++){
                spiral[i][j] = result.get(k);
                k++;
            }
        }
        for (int[] e:spiral){
            System.out.println(Arrays.toString(e));
        }
    }
    private static int[][] createMatrix(int n){
        int[][] matrix = new int[n][n];
        int i = 1;
        for (int j=0; j<n; j++){
            for (int k=0; k<n; k++){
                matrix[j][k] = i;
                i++;
            }
        }

        return matrix;
    }

    private static void helper(List<Integer> list, int[][] matrix, int n, int r, int c, char d) {
        if (r==n || r<0 || c==n || c<0 || matrix[r][c]==101){
            return;
        }
        list.add(matrix[r][c]);
        matrix[r][c] = 101;
        if (d=='R'){
            helper(list, matrix, n, r, c+1, 'R');
            d ='D';
        }
        if (d=='D'){
            helper(list, matrix, n, r+1, c, 'D');
            d = 'L';
        }
        if (d=='L'){
            helper(list, matrix, n, r, c-1, 'L');
            d = 'T';
        }
        if (d=='T'){
            helper(list, matrix, n, r-1, c, 'T');
            d = 'R';
            helper(list, matrix,n, r, c+1, 'R');
        }
    }
}
