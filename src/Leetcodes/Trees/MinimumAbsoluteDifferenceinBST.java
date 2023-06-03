package Leetcodes.Trees;

import Leetcodes.DFS.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MinimumAbsoluteDifferenceinBST {
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
//        List<Integer> inOrder = new ArrayList<>();
//        helper(root, inOrder);
//        for (int i=0; i<inOrder.size(); i++){
//            int diff = inOrder.get(i+1) - inOrder.get(i);
//            if (diff < min){
//                min = diff;
//            }
//        }
//        return min;
    }
    private void helper(TreeNode root, List<Integer> inOrder) {
        if(root == null){
            return;
        }
        helper(root.left, inOrder);
        inOrder.add(root.val);
        helper(root.right, inOrder);
    }
}
