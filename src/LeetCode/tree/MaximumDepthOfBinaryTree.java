package LeetCode.tree;

public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        int res = maxDepthHelper(root);
        System.out.println(res);
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
