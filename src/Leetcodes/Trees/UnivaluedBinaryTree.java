package Leetcodes.Trees;

import Leetcodes.DFS.TreeNode;

public class UnivaluedBinaryTree {
    public static void main(String[] args) {

    }
    public boolean isUnivalTree(TreeNode root) {
        while(root!=null){
            if (root.val != root.left.val || root.val!=root.right.val){
                return false;
            }
        }
        if (root == null){
            return true;
        }
        if (root.left!=null && root.right!=null){
            if (root.val != root.left.val || root.val != root.right.val){
                return false;
            }
        }

        return isUnivalTree(root.left) && isUnivalTree(root.right);
    }
}
