package LeetCode.tree;

public class MinimumDepthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        int res = minDepthHelper(root);
        System.out.println(res);
    }

    private static int minDepthHelper(TreeNode root) {
        if (root == null){
            return 0;
        }
        if (root.left == null && root.right == null){
            return 1;
        }
        int left =  1 + minDepthHelper(root.left);
        int right =  1 + minDepthHelper(root.right);
        if (root.left == null){
            return right;
        }
        if (root.right == null){
            return left;
        }
        return Math.min(left, right);
    }
}
