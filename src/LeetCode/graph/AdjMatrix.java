package LeetCode.graph;

import java.util.Arrays;

public class AdjMatrix {

    public static void main(String[] args) {
        int m = 5;
        int n = 5;
        int[][] arr = new int[m+1][n+1];
        int[][] edges = {{1,2}, {1,3}, {2,4}, {3,4}, {2,5}, {4,5}};

        for (int i=0; i<edges.length-1; i++){
            arr[i][i+1] = edges[i][i+1];
            arr[i+1][i] = edges[i+1][i];

        }
        System.out.println(Arrays.toString(arr));
    }
}
