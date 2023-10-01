package LeetCode.tree;

public class SymmetricTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        boolean res = isSymmetricHelper(root.left, root.right);
        System.out.println(res);
    }

    private static boolean isSymmetricHelper(TreeNode firstTree, TreeNode secondTree) {
        if (firstTree == null && secondTree == null){
            return true;
        }
        if (firstTree == null || secondTree == null){
            return false;
        }
        if ( firstTree.val != secondTree.val){
            return false;
        }
        boolean leftRight = isSymmetricHelper(firstTree.left, secondTree.right);
        boolean rightLeft = isSymmetricHelper(firstTree.right, secondTree.left);
        return  leftRight && rightLeft;
    }
}
