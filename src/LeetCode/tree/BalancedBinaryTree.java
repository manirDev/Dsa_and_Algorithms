package LeetCode.tree;

public class BalancedBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        boolean res = balancedBinaryTreeHelper(root);
        System.out.println(res);
    }

    private static boolean balancedBinaryTreeHelper(TreeNode root) {
        if (root == null){
            return true;
        }
        int left = maxDepthHelper(root.left);
        int right = maxDepthHelper(root.right);
        if (Math.abs(left - right) <= 1 && balancedBinaryTreeHelper(root.left) && balancedBinaryTreeHelper(root.right)){
            return true;
        }
        return false;
    }
    private static int maxDepthHelper(TreeNode root) {
        if (root == null){
            return 0;
        }
        int leftDepth = 1 + maxDepthHelper(root.left);
        int rightDepth = 1 + maxDepthHelper(root.right);
        return Math.max(leftDepth, rightDepth);
    }
}
