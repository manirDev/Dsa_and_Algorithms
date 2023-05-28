package Leetcodes.BinarySearch;

public class Search2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}
            };
        int target = 3;
        System.out.println(searchMatrix(matrix, target));
    }

    private static boolean searchMatrix(int[][] matrix, int target) {
        /*******************Brute Force**********************/
        // for(int i=0; i<matrix.length; i++){
        //     for(int j=0; j<matrix[0].length; j++){
        //         if(matrix[i][j] == target){
        //             return true;
        //         }
        //     }
        // }
        // return false;
        /*******************Binary Search**********************/

        int row = matrix.length;
        for(int i=0; i<row; i++){
            int start = 0;
            int end = matrix[0].length - 1;
            while(start<=end){
                int mid = start + (end - start)/2;
                if(matrix[i][mid]==target){
                    return true;
                }else if(matrix[i][mid] < target){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
        }
        return false;
    }
}
