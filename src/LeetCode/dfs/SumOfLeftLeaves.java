package LeetCode.dfs;

import LeetCode.tree.TreeNode;

public class SumOfLeftLeaves {
    static int sum = 0;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        int res = leftLeavesSumHelper(root);
        System.out.println(res);
    }

    private static int leftLeavesSumHelper(TreeNode root) {
        if (root == null){
            return 0;
        }
        if (root.left!=null&& root.left.left==null && root.left.right==null){
            sum+=root.left.val;
        }
        leftLeavesSumHelper(root.left);
        leftLeavesSumHelper(root.right);
        return sum;
    }
}
