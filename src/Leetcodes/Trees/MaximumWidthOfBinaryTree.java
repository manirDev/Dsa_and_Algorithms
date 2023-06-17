package Leetcodes.Trees;

import Leetcodes.DFS.TreeNode;
import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class MaximumWidthOfBinaryTree {
    public static void main(String[] args) {

    }

    private int widthOfBinaryTree(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        int treeHeight = height(root);
        for (int i=1; i<=treeHeight; i++){
            List<Integer> temp = new ArrayList<>();
            helper(root, temp, i);
            levels.add(new ArrayList<>(temp));
        }
        int maxLen = Integer.MIN_VALUE;
        for (List<Integer> level: levels) {
            if (level.size() > maxLen){
                maxLen = level.size();
            }
        }
        return maxLen;
    }

    private int height(TreeNode root){
        if (root == null){
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }
    private void helper(TreeNode root, List<Integer> list, int level){
        if (root == null){
            list.add(null);
            return;
        }
        if (level == 1){
            list.add(root.val);
        }
        if (level > 1){
            helper(root.left, list, level - 1);
            helper(root.right, list, level - 1);
        }
    }
}
