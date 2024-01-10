package LeetCode.recursion;

import LeetCode.tree.TreeNode;

public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);
        boolean res = validateBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println(res);
    }

    private static boolean validateBSTHelper(TreeNode root, int min_val, int max_val) {
        if (root == null){
            return true;
        }
        if (root.val <= min_val){
            return false;
        }
        if (root.val >= max_val){
            return false;
        }
        return validateBSTHelper(root.left, min_val, root.val) && validateBSTHelper(root.right, root.val, max_val);
    }
}
