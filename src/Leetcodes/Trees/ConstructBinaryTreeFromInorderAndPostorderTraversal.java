package Leetcodes.Trees;

import Leetcodes.DFS.TreeNode;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {

    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode root = helper(inorder, postorder, 0, inorder.length-1, postorder.length-1);
        return root;
    }

    //inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
    //last element in postorder is the root of each subtree
    public TreeNode helper(int[] in,int[] post,int low,int high, int rootPos){
        if(low>high){
            return null;
        }
        TreeNode root=new TreeNode(post[rootPos]);
        int rootIndex = findPosition(in,low,high,post[rootPos]);
        root.left =  helper(in,post,low,rootIndex - 1, rootPos-1);
        root.right = helper(in,post,rootIndex + 1,high, rootPos-1);
        return root;
    }
    public int findPosition(int[] inorder,int low,int high,int key){
        for(int i=low;i<=high;i++){
            if(key==inorder[i])
                return i;
        }
        return -1;
    }
}
