package Leetcodes.DFS;

public class InvertBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

    }
    private TreeNode helper(TreeNode root) {
        if (root == null){
            return null;
        }
        TreeNode temp =helper(root.left);
        root.left = helper(root.right);
        root.right = temp;
        return root;
    }
}
