package LeetCode.tree;

public class DiameterOfBinaryTree {
    static int res = Integer.MIN_VALUE;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        treeDiameterHelper(root);
        System.out.println(res);
    }

    private static int treeDiameterHelper(TreeNode root) {
        if (root == null){
            return 0;
        }
        int left = treeDiameterHelper(root.left);
        int right = treeDiameterHelper(root.right);
        res = Math.max(res, (left + right));
        return 1  + Math.max(left, right);
    }
}
