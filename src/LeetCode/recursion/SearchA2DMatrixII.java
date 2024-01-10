package LeetCode.recursion;

public class SearchA2DMatrixII {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}
        };
        int target = 7;
        boolean res = isFindHelper(matrix, 0, matrix[0].length - 1, target);
        System.out.println(res);
    }

    private static boolean isFindHelper(int[][] matrix, int row, int col, int target) {
        if (row >= matrix.length || col < 0){
            return false;
        }
        if (matrix[row][col] < target){
            return isFindHelper(matrix, row + 1, col, target);
        }
        else if(matrix[row][col] > target){
            return isFindHelper(matrix, row, col - 1, target);
        }
        return true;

    }


}
