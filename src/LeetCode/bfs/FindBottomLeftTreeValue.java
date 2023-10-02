package LeetCode.bfs;

import LeetCode.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftTreeValue {
    public static void main(String[] args) {
        TreeNode root = new TreeNode( 1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        int res = findBottomLeftValueHelper(root);
        System.out.println(res);
    }

    private static int findBottomLeftValueHelper(TreeNode root) {
       return 0;
    }
}
