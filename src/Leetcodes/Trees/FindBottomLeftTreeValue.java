package Leetcodes.Trees;

import Leetcodes.DFS.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FindBottomLeftTreeValue {
    public static void main(String[] args) {

    }

    public int findBottomLeftValue(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, 0, height(root), res);
        return res.size() > 0 ? res.get(0) : 0;
    }
    private int height(TreeNode root){
        if (root == null){
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }
    private void helper(TreeNode root, int level, int height, List<Integer> list){
        if (root == null){
            return;
        }
        if (level == height){
            list.add(root.val);
        }
        helper(root.left, level + 1, height, list);
        helper(root.right, level + 1, height, list);
    }
}
