package DSA_LearningProcess.Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an m x n matrix of distinct numbers, return all lucky numbers in the matrix in any order.
 *
 * A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.
 */
public class LuckyNumbersInAMatrix {
    public static void main(String[] args) {
        int[][] matrix =  {
                {3,7,8},
                {9,11,13},
                {15,16,17}
            };
        List<Integer> result =  helper(matrix, matrix.length, matrix[0].length);
        System.out.println(result);
    }
    private static List<Integer> helper(int[][] m, int row, int col){
        List<Integer> list = new ArrayList<>();
        int[] maxElements = new int[col];
        int[] minElements = new int[row];

        //populate minElements array
        for(int r=0; r<row; r++){
            int min = Integer.MAX_VALUE;
            for(int c=0; c<col; c++){
                if(m[r][c] < min){
                    min = m[r][c];
                }
            }
            minElements[r] = min;
        }

        //populate maxElements array
        for(int c=0; c<col; c++){
            int max = Integer.MIN_VALUE;
            for(int r=0; r<row; r++){
                if(m[r][c] > max){
                    max = m[r][c];
                }
            }
            maxElements[c] = max;
        }

        //make comparison for the two arrays
        for(int i=0; i<minElements.length; i++){
            for (int j=0; j<maxElements.length; j++){
                if(minElements[i] == maxElements[j]){
                    list.add(minElements[i]);
                }
            }
        }
        return list;
    }
}
