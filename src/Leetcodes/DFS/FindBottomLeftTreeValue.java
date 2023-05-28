package Leetcodes.DFS;

public class FindBottomLeftTreeValue {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.right = new TreeNode(3);

        System.out.println(helper(root, 0));
    }

    public static int helper(TreeNode root, int level) {
        if(root == null){
            return 0;
        }
        helper(root.left, level+1);
        helper(root.left, level+1);
        return 1;
    }
}
