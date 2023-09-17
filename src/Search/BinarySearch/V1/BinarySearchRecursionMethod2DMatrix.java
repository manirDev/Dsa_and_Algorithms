package Search.BinarySearch.V1;

public class BinarySearchRecursionMethod2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}
        };
        int target = 3;
        int row = matrix.length;
        boolean  result = false;
        for (int i=0; i<row; i++){
            int start = 0;
            int end = matrix[i].length - 1;
            result = helper(matrix, i, start, end, target);
            if(result){
                System.out.println("True");
                break;
            }
        }
        if (!result){
            System.out.println("False");
        }
    }

    private static boolean helper(int[][] matrix, int i, int start,int end, int target){
        if(start > end){
            return false;
        }
        int mid = start + (end - start)/2;

        if(matrix[i][mid] > target){
            return helper(matrix, i, start, mid-1, target);
        }
        else if (matrix[i][mid] < target){
            return helper(matrix, i, mid+1, end, target);
        }
        else {
            return true;
        }
    }
}
