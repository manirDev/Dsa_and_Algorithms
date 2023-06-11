package Leetcodes.Trees;

import Leetcodes.DFS.TreeNode;

public class DeleteLeavesWithAGivenValue {
    public static void main(String[] args) {

    }

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null){
            return null;
        }
        if (root.val == target && root.left == null && root.right == null){
            return null;
        }
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);
        return root;
    }
}
