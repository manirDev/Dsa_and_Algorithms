package LeetCode.binarySearch;

public class searchMatrixII {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
            };

        int target = 5;
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
