package LeetCode.heap;

import java.util.*;

public class KthSmallestElementInASortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,5,9},
                {10,11,13},
                {12,13,15}
        };
        int k = 8;
        int res = kthSmallestInAMatrixHelper(matrix, k);
        System.out.println(res);
    }

    private static int kthSmallestInAMatrixHelper(int[][] matrix, int k) {
        PriorityQueue<Integer[]> heap = new PriorityQueue<>(new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] val1, Integer[] val2) {
                return val1[2] - val2[2];
            }
        }
        );
        for (int r=0; r<matrix.length; r++){
            heap.add(new Integer[]{r, 0, matrix[r][0]});
        }
        Integer[] res = heap.peek();
        while (k > 0){
            int row = heap.peek()[0];
            int col = heap.peek()[1];
            res = heap.peek();
            heap.remove();
            if (col + 1 < matrix[row].length){
                heap.add(new Integer[]{row, col + 1, matrix[row][col + 1]});
            }
            k--;
        }
        return res[2];
    }
}
