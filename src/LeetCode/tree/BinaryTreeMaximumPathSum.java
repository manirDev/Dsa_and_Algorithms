package LeetCode.tree;

public class BinaryTreeMaximumPathSum {
    static int maxSum = Integer.MIN_VALUE;
    public static void main(String[] args) {
        TreeNode root  = new TreeNode(-10);
        root.left= new TreeNode(9);
        root.left.left= new TreeNode(3);
        root.left.right= new TreeNode(4);
        root.right= new TreeNode(20);
        root.right.left= new TreeNode(15);
        root.right.right= new TreeNode(7);
        if (countNodes(root) == 1){
            System.out.println(root.val);
        }
        maxPathSumHelper(root);
        System.out.println(maxSum);
    }

    private static int maxPathSumHelper(TreeNode root) {
        if (root == null){
            return 0;
        }
        int left = maxPathSumHelper(root.left);
        int right = maxPathSumHelper(root.right);
        int leftSum  = root.val + left;
        int rightSum = root.val + right;
        int maxRootLeftRightSums =  Math.max(root.val, Math.max(leftSum, rightSum));
        int rootLeftRightSum = root.val + left + right;
        maxSum = Math.max(maxSum, Math.max(maxRootLeftRightSums, rootLeftRightSum));
        return maxRootLeftRightSums;
    }
    private static int countNodes(TreeNode root){
        if (root == null){
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
