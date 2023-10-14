package LeetCode.graph;

import javax.swing.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FloodFill {
    public static void main(String[] args) {
        int[][] image = {
                        {0,0,0},
                        {0,0,0}
                        };
        int sr = 1, sc = 0, color = 2;
        Set<String> visited = new HashSet<>();
        floodFillHelper(image, sr, sc, color, image[sr][sc], visited);
        System.out.println(Arrays.deepToString(image));
    }

    private static void floodFillHelper(int[][] image, int sr, int sc, int color, int prevColor, Set<String> visited) {
        if (!(sr >= 0 && sr < image.length) || !(sc >= 0 && sc < image[0].length)){
            return;
        }
        String curCell = sr +","+ sc;
        if (image[sr][sc] != prevColor || visited.contains(curCell)){
            return;
        }
        visited.add(curCell);
        image[sr][sc] = color;
        floodFillHelper(image, sr-1, sc, color, prevColor, visited);
        floodFillHelper(image, sr+1, sc, color, prevColor, visited);
        floodFillHelper(image, sr, sc-1, color, prevColor, visited);
        floodFillHelper(image, sr, sc+1, color, prevColor, visited);
    }
}
