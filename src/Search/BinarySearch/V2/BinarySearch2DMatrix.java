package Search.BinarySearch.V2;

import java.util.Arrays;

public class BinarySearch2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {28, 29, 37, 49},
                {33, 34, 38, 50},
        };

        int target = 50;
        int row = matrix.length;
        int col = matrix[0].length;
        System.out.println("BSA in 2D Array Function:");
        long time;
        time = System.currentTimeMillis();
        System.out.println("BSA: "  + Arrays.toString(helper(matrix, target, row, col)));
        System.out.printf("Time: %d ms\n", System.currentTimeMillis() - time);
        time = System.currentTimeMillis();
        System.out.println("Sored in row and col wire: "  + Arrays.toString(helperSortedInRowAndColWire(matrix, target)));
        System.out.printf("Time: %d ms\n", System.currentTimeMillis() - time);

    }

    static int[] helper(int[][] m, int t, int r, int c) {
        for (int i=0; i<r; i++){
            int s = 0;
            int e = c - 1;
            while(s <= e){
                int mid = s  + (e - s)/2;
                if (m[i][mid] == t){
                    return new int[]{i, mid};
                }
                else if(m[i][mid] < t){
                    s = mid + 1;
                }
                else {
                    e = mid - 1;
                }
            }
        }
        return new int[]{-1, -1};
    }
    static int[] helperSortedInRowAndColWire(int[][] m, int t){
        int r = 0;
        int c = m.length - 1;
        while (r<m.length && c >=0){
            if (m[r][c] == t){
                return new int[]{r, c};
            }
            else if (m[r][c] < t){
                r++;
            }else{
                c--;
            }
        }
        return new int[]{-1, -1};
    }
}
