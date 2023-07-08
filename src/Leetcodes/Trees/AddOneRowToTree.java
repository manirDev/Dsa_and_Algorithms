package Leetcodes.Trees;

import Leetcodes.DFS.TreeNode;
import com.sun.source.tree.Tree;

public class AddOneRowToTree {
    public static void main(String[] args) {

    }

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1){
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        helper(root, val, depth, 1);
        return root;
    }
    private void helper(TreeNode root, int val, int depth, int level){
        if (root == null){
            return;
        }
        if (level == depth-1){
            TreeNode tempLeft = root.left;
            root.left = new TreeNode(val);
            root.left.left = tempLeft;
            TreeNode tempRight = root.right;
            root.right = new TreeNode(val);
            root.right.right = tempRight;
        }
        helper(root.left, val, depth, level + 1);
        helper(root.right, val, depth, level + 1);
    }
}
