package Leetcodes.Trees;

import Leetcodes.DFS.TreeNode;
import com.sun.source.tree.Tree;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {

    }
    int preIndex = 0;
    public TreeNode buildTree(int[] inorder, int[] preorder) {
        preIndex = 0;
        TreeNode root = helper(inorder, preorder, 0, inorder.length - 1);
        return root;
    }

    private TreeNode helper(int[] inorder, int[] preorder, int low, int high){
        if (low > high){
            return null;
        }
        if (preIndex >= preorder.length){
            return  null;
        }
        TreeNode root = new TreeNode(preorder[preIndex]);
        int rootIndex = findRootIndex(inorder, low, high, preorder[preIndex++]);
        root.left = helper(inorder, preorder, low, rootIndex - 1);
        root.right = helper(inorder, preorder, rootIndex + 1, high);
        return root;
    }
    private int findRootIndex(int[] inorder, int low, int high, int key){
        for (int i=low; i<=high; i++){
            if (inorder[i] == key){
                return i;
            }
        }
        return -1;
    }
}
