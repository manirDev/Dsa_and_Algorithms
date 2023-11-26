package LeetCode.tree;

public class LCA {
    static TreeNode res = new TreeNode();
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        lcaHelper(root, root.left.left,  root.left.right.left);
        System.out.println(res.val);
    }
    private static boolean lcaHelper(TreeNode root, TreeNode p, TreeNode q){
        if (root == null){
            return false;
        }

        int left = lcaHelper(root.left, p, q) ? 1 : 0;
        int right = lcaHelper(root.right, p, q) ? 1 : 0;
        int rootItSelf = (root == p || root == q) ? 1 : 0;
        if (left + right + rootItSelf == 2){
            res = root;
        }
        return (left + right + rootItSelf) > 0;
    }
}
