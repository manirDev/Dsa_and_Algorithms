package Leetcodes.DFS;

public class BinaryTreeMaximumPathSum {
    static int result = Integer.MIN_VALUE;
    public static void main(String[] args) {
        // Create the binary tree manually
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int size = countSize(root);
        //if(size==1) return root.val;
        helper(root);
        System.out.println(result);
    }
    private static int countSize(TreeNode root){
        if(root==null) return 0;
        return 1+countSize(root.left) + countSize(root.right);
    }
    private static int helper(TreeNode root) {
        if (root == null){
            return 0;
        }

        int left = helper(root.left);
        int right = helper(root.right);
        int leftSum = root.val+left;
        int rightSum = root.val+right;
        int Max_Between_Sums_and_root = Math.max(root.val, Math.max(leftSum, rightSum));
        int sum_of_all_Three = root.val + left + right;
        result = Math.max(result, Math.max(sum_of_all_Three, Max_Between_Sums_and_root));
        return Max_Between_Sums_and_root;
    }
}
