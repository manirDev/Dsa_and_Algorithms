package Leetcodes.Trees;

import Leetcodes.DFS.TreeNode;
import com.sun.source.tree.Tree;

public class BalancedBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(helper(root));
    }
    private static boolean helper(TreeNode root) {

        if (root == null){
            return true;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (Math.abs(leftHeight - rightHeight) <= 1 && helper(root.left) && helper(root.right)){
            return true;
        }
        return false;
    }
    private static int height(TreeNode root){
        if (root == null){
            return 0;
        }

        return 1 + Math.max(height(root.left), height(root.right));
    }
}
