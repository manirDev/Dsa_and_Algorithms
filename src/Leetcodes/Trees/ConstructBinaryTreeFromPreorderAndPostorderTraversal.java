package Leetcodes.Trees;

import Leetcodes.DFS.TreeNode;

public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {
    public static void main(String[] args) {

    }
    int posIndex = 0;
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return helper(preorder, postorder, 0, postorder.length-1);
    }

    //Input: preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
    //Output: [1,2,3,4,5,6,7]
    private TreeNode helper(int[] preorder, int[] postorder, int low, int high){
        if (low > high){
            return null;
        }
        if (posIndex >= preorder.length){
            return null;
        }
        TreeNode root = new TreeNode(preorder[posIndex]);
        int rootIndex = findRootIndex(postorder, low, high, preorder[posIndex++]);
        root.left = helper(preorder, postorder, low, rootIndex - 1);
        root.right = helper(preorder, postorder, rootIndex + 1, high);
        return root;
    }

    private int findRootIndex(int[] postorder, int low, int high, int key){
        int index = low;
        for (int i=low; i<=high; i++){
            if (key == postorder[i]){
                index = i;
                break;
            }
        }
        return index;
    }
}
