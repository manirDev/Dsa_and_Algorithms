package Leetcodes.Trees;

import Leetcodes.DFS.TreeNode;

public class ConstructBinarySearchTreefromPreorderTraversal {
    public static void main(String[] args) {

    }

    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, 0, preorder.length);
    }
    private TreeNode helper(int[] preorder, int start, int end){
        if (start > end){
            return null;
        }
        TreeNode root = new TreeNode(preorder[start]);
        int index = findIndex(preorder, start);
        root.left = helper(preorder, start+1, index-1);
        root.right = helper(preorder, index, end);
        return root;
    }

    private int findIndex(int[] preorder, int start){
        int i = start+1;
        while (i < preorder.length && preorder[i] < preorder[start]){
            i++;
        }
        return i;
    }
}
