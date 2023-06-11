package Leetcodes.Trees;

import Leetcodes.DFS.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideViewV2 {
    public static void main(String[] args) {

    }

    public List<Integer> rightSideView(TreeNode root){
        List<Integer> result = new ArrayList<>();
        helper(root, result, 0);
        return result;
    }
    private void helper(TreeNode  root, List<Integer> ds, int level){
        if (root == null){
            return;
        }
        if (level == ds.size()){
            ds.add(root.val);
        }
        helper(root.right, ds, level+1);
        helper(root.left, ds, level+1);
    }
}
