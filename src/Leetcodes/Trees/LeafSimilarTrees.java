package Leetcodes.Trees;

import Leetcodes.DFS.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees {
    public static void main(String[] args) {

    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        helper(root1, list1);
        helper(root2, list2);
        return list2.equals(list1);
    }

    private void helper(TreeNode root, List<Integer> list){
        if (root == null){
            return;
        }
        if (root.left == null && root.right == null){
            list.add(root.val);
        }
        helper(root.left, list);
        helper(root.right, list);
    }
}
