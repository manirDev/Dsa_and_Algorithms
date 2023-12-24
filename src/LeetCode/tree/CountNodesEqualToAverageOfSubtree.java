package LeetCode.tree;

public class CountNodesEqualToAverageOfSubtree {
    static int res = 0;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(8);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        helper(root);
        System.out.println(res);
    }
    private static void helper(TreeNode root){
        if (root == null){
            return;
        }

        int leftNodes = 0;
        int leftSum = 0;
        int rightNodes = 0;
        int rightSum = 0;
        if (root.left != null){
            leftNodes = countNodesHelper(root.left);
            leftSum = sumNodesHelper(root.left);
        }
        if (root.right != null){
            rightNodes = countNodesHelper(root.right);
            rightSum = sumNodesHelper(root.right);
        }
        int countNodes = 1 + leftNodes + rightNodes;
        int sumNodes = root.val + leftSum + rightSum;
        int avg = sumNodes / countNodes;
        if (avg == root.val){
            res = res + 1;
        }
        helper(root.left);
        helper(root.right);
    }

    private static int countNodesHelper(TreeNode root) {
        if (root == null){
            return 0;
        }
        return (1 + countNodesHelper(root.left) + countNodesHelper(root.right));
    }

    private static int sumNodesHelper(TreeNode root) {
        if (root == null){
            return 0;
        }
        return (root.val + sumNodesHelper(root.left) + sumNodesHelper(root.right));
    }
}
