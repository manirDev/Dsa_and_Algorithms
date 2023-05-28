package Leetcodes.DFS;

import com.sun.source.tree.Tree;

public class DeleteNodeInABST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
    }
    public static TreeNode helper(TreeNode root, int key) {
        if(root == null){
            return root;
        }
        if (root.val > key){
            root.left = helper(root.left, key);
        } else if (root.val < key) {
           root.right = helper(root.right, key);
        }
        else{
            //delete of nodes with one child
            if (root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }
            //if the node has two child, we see for the min in the right subtree to replace root node which will be deleted.
            TreeNode min_node_in_rightSubTree = minNode(root.right);
            root.val = min_node_in_rightSubTree.val;
            root.right = helper(root.right, root.val);
        }
        return root;
    }
    private static TreeNode minNode(TreeNode root){
        while (root.left!=null){
            root = root.left;
        }
        return root;
    }
}
