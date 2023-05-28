package Leetcodes.Arrays;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] result = helper(intervals);
        for (int i=0; i<result.length; i++){
            System.out.println(result[i][0]);
        }
    }

    private static int[][] helper(int[][] intervals) {
        int m = intervals.length;
        int n = intervals[0].length;
        int[][] result = new int[m][n];
        int r = 0,  c = 0;
        for (int i=0; i<m-1; i++){
            for (int j=0; j<n-1; j++){
                int left = Math.max(intervals[i][j], intervals[i+1][j]);
                int right = Math.min(intervals[i][j+1], intervals[i+1][j+1]);
                if (left <= right && r<m && c<n){
                    result[r][c] = intervals[i][j];
                    result[r][c+1]  = intervals[i+1][j+1];
                }
            }
        }

        return result;
    }
}
