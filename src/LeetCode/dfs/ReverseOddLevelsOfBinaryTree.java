package LeetCode.dfs;

import LeetCode.tree.TreeNode;

public class ReverseOddLevelsOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode( 2);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(13);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(21);
        root.right.right = new TreeNode(34);
        reverseOddLevelsHelper(root.left, root.right, 0);
    }

    private static void reverseOddLevelsHelper(TreeNode leftTree, TreeNode rightTree, int level) {
        if (leftTree == null || rightTree == null){
            return;
        }
        if (level % 2 != 0 ){
            int temp = leftTree.val;
            leftTree.val = rightTree.val;
            rightTree.val = temp;
        }
        reverseOddLevelsHelper(leftTree.left, rightTree.right, level + 1);
        reverseOddLevelsHelper(leftTree.right, rightTree.left, level + 1);
    }
}
