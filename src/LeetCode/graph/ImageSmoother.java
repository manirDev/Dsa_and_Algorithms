package LeetCode.graph;

import java.util.Arrays;

public class ImageSmoother {
    public static void main(String[] args) {
        int[][] image = {
                {100,200,100},
                {200,50,200},
                {100,200,100}
        };
       /* [137,141,137],
        [141,138,141],
        [137,141,137] */
        int[][] res = filterHelper(image);
        for (int[] row : res){
            System.out.println(Arrays.toString(row));
        }
    }

    private static int[][] filterHelper(int[][] image) {
        int[][] res = new int[image.length][image[0].length];
        int[] rowDirs = {0,0,1,-1,-1,-1,1,1};
        int[] colDirs = {1,-1,0,0,-1,1,-1,1};
        for (int i=0; i<image.length; i++){
            for (int j=0; j<image[i].length; j++){
                int sum = image[i][j];
                int count = 1;
                for (int k=0; k<8; k++){
                    int row = i + rowDirs[k];
                    int col = j + colDirs[k];
                    if (isValidCell(image, row, col)){
                        sum = sum + image[row][col];
                        count = count + 1;
                    }
                }
                res[i][j] = (int) Math.floor((double)sum/count);
            }
        }
        return res;
    }
    private static boolean isValidCell(int[][] image, int row, int col){
        boolean rowInBounds = row >= 0 && row < image.length;
        boolean colInBounds = col >= 0 && col < image[0].length;
        if (!rowInBounds || !colInBounds){
            return false;
        }
        return true;
    }
}
