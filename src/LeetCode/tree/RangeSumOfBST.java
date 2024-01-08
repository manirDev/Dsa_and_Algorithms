package LeetCode.tree;

public class RangeSumOfBST {
    static int sum = 0;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right = new TreeNode(15);
        root.right.right = new TreeNode(18);
        int low = 7;
        int high = 15;
        int res = rangeSumBSTHelper(root, low, high);
        System.out.println(res);
    }

    private static int rangeSumBSTHelper(TreeNode root, int low, int high) {
        if (root == null){
            return 0;
        }
        if (low <= root.val && root.val <= high){
            sum = sum + root.val;
        }
        rangeSumBSTHelper(root.left, low, high);
        rangeSumBSTHelper(root.right, low, high);
        return sum;
    }
}
