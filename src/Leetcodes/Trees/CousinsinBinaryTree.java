package Leetcodes.Trees;

import Leetcodes.DFS.TreeNode;
import com.sun.source.tree.Tree;

public class CousinsinBinaryTree {
    public static void main(String[] args) {

    }
    int xLevel = 0;
    TreeNode xParent = null;
    int yLevel = 0;
    TreeNode yParent = null;

    public boolean isCousins(TreeNode root, int x, int y) {
        helper(root, x, y, 0, null);
        return (yLevel == xLevel) && (yParent != xParent) ? true : false;
    }

    private void helper(TreeNode root, int x, int y, int level, TreeNode parent){
        if (root == null){
            return;
        }
        if (root.val == x){
            xLevel = level;
            xParent = parent;
        }
        if (root.val == y){
            yLevel = level;
            yParent = parent;
        }
        helper(root.left, x, y, level + 1, root);
        helper(root.right, x, y, level + 1, root);
    }
}
