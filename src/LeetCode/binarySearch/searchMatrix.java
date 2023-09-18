package LeetCode.binarySearch;

public class searchMatrix {
    public static void main(String[] args) {
//        int[][] matrix = {
//                {1, 3, 5, 7},
//                {10, 11, 16, 20},
//                {23, 30, 34, 60}
//            };
        int[][] matrix = {{1,3}};
        int target = 3;
        System.out.println(helper(matrix, target, 0, matrix[0].length - 1));
    }

    private static boolean helper(int[][] matrix, int target, int row, int col) {
        while (row < matrix.length && col>=0){
            if (matrix[row][col] == target){
                return true;
            }
            else if (matrix[row][col] > target){
                col--;
            }
            else {
                row++;
            }
        }
        return false;
    }
}
