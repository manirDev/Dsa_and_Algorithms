package Leetcodes.Trees;

import Leetcodes.DFS.TreeNode;

public class DeepestLeavesSum {
    public static void main(String[] args) {

    }
    public int deepestLeavesSum(TreeNode root) {
        int sum = 0;
        helper(root, height(root), sum);
        return sum;
    }

    private int height(TreeNode root){
        if (root == null){
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }
    private void helper(TreeNode root,int level, int sum){
        if (root == null){
            return;
        }
        if (level == 1){
            sum = sum + root.val;
        }
        helper(root.left, level - 1, sum);
        helper(root.right, level - 1, sum);
    }
}
