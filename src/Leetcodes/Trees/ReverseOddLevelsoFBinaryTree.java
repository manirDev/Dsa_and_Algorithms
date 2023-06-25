package Leetcodes.Trees;

import Leetcodes.DFS.TreeNode;

public class ReverseOddLevelsoFBinaryTree {
    public static void main(String[] args) {

    }

    public TreeNode reverseOddLevels(TreeNode root) {
        helper(root.left, root.right, 0);
        return root;
    }

    private void helper(TreeNode root1, TreeNode root2, int level){
        if (root1 == null || root2 == null){
            return;
        }
        if (level % 2 != 0){
            int temp = root1.val;
            root1.val = root2.val;
            root2.val = temp;
        }
        helper(root1.left, root2.right, level+1);
        helper(root1.right, root2.left, level+1);
    }

}
