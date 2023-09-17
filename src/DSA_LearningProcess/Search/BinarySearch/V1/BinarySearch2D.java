package DSA_LearningProcess.Search.BinarySearch.V1;

public class BinarySearch2D {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
            };
        int target = 88;
        int[] index = helper(matrix, target);
        for (int e: index) {
            System.out.println(e);
        }
    }

    private static int[] helper(int[][] matrix, int target){
        int row = matrix.length;
        for (int i=0; i<row; i++){
            int start = 0;
            int end = matrix[i].length - 1;
            while(start<=end){
                int mid = start + (end - start)/2;
                if(matrix[i][mid] == target){
                    return new int[]{i, mid};
                }
                else if (matrix[i][mid] > target){
                    end  = mid - 1;
                }
                else {
                    start = mid + 1;
                }
            }
        }
        return new int[]{-1,-1};
    }
}
