package LeetCode.graph;

import LeetCode.linkedList.ListNode;

import java.util.Arrays;

public class SpiralMatrixIV {
    public static boolean isHeadNull = false;
    public static void main(String[] args) {
        int m = 3, n = 5;
        ListNode head = new ListNode(0);
        head = head.insertNode(head, 5);
        head = head.insertNode(head, 5);
        head = head.insertNode(head, 2);
        head = head.insertNode(head, 4);
        head = head.insertNode(head, 9);
        head = head.insertNode(head, 7);
        head = head.insertNode(head, 1);
        head = head.insertNode(head, 8);
        head = head.insertNode(head, 6);
        head = head.insertNode(head, 2);
        head = head.insertNode(head, 0);
        head = head.insertNode(head, 3);
        //head.print(head);

        int[][] grid = new int[m][n];
        spiralConstructHelper(grid, head, m, n, 0, 0, new boolean[m][n], 'R');
        for (int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
    }

    private static void spiralConstructHelper(int[][] grid, ListNode head, int m, int n, int i, int j, boolean[][] visited, char dir) {
        boolean rowInBounds = i >= 0 && i < m;
        boolean colInBounds = j >= 0 && j < n;
        if (!rowInBounds || !colInBounds|| visited[i][j]){
            return;
        }
        ListNode negativeNode = new ListNode(-1);;
        if (head == null){
            head = negativeNode;
        }
        grid[i][j] = head.val;
        visited[i][j] = true;
        if (dir == 'R'){
            spiralConstructHelper(grid, head.next, m, n, i, j + 1, visited, dir);
            dir = 'D';
        }
        if (dir == 'D'){
            spiralConstructHelper(grid, head.next, m, n, i + 1, j, visited, dir);
            dir = 'L';
        }
        if (dir == 'L'){
            spiralConstructHelper(grid, head.next, m, n, i, j - 1, visited, dir);
            dir = 'U';
        }
        if (dir == 'U'){
            spiralConstructHelper(grid, head.next, m, n, i - 1, j, visited, dir);
            dir = 'R';
            spiralConstructHelper(grid, head.next, m, n, i, j + 1, visited, dir);
        }
    }
}
