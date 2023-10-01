package LeetCode.dfs;

import LeetCode.tree.TreeNode;

public class PathSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left.left = new TreeNode(1);
        int targetSum = 22;
        boolean res = pathSumHelper(root, targetSum);
        System.out.println(res);
    }

    private static boolean pathSumHelper(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        targetSum = targetSum - root.val;
        if (root.left == null && root.right == null){
            if (targetSum == 0){
                return true;
            }
        }
        boolean left = pathSumHelper(root.left, targetSum);
        boolean right = pathSumHelper(root.right, targetSum);
        return left || right;
    }
}
