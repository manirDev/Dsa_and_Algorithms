package Leetcodes.Trees;

import Leetcodes.DFS.TreeNode;
import com.sun.source.tree.Tree;

public class MergeTwoBinaryTrees {
    public static void main(String[] args) {

    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        TreeNode root = new TreeNode();
        if (root2 == null){
            return root1;
        }
        if (root1 == null){
            return root2;
        }
        root.val = root1.val + root2.val;
        root.left = mergeTrees(root1.left, root2.left);
        root.right = mergeTrees(root1.right, root2.right);
        return root;
    }
}
