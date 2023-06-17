package Leetcodes.Trees;

import Leetcodes.DFS.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MaximumLevelSumOfABinaryTree {
    public static void main(String[] args) {

    }
    public int maxLevelSum(TreeNode root) {
        int treeHeight = height(root);
        List<List<Integer>> levels = new ArrayList<>();
        for (int i=1; i<=treeHeight; i++){
            List<Integer> list = new ArrayList<>();
            helper(root, list, i);
            levels.add(new ArrayList<>(list));
        }
        List<Integer> sums = new ArrayList<>();
        for (int i=0; i<levels.size(); i++){
            int sum = 0;
            for(int j=0; j<levels.get(i).size(); j++){
                sum = sum + levels.get(i).get(j);
            }
            sums.add(sum);
        }
        int max = 0;
        int index = 0;
        for (int i=0; i<sums.size(); i++){
            if (sums.get(i) > max){
                max = sums.get(i);
                index = i;
            }
        }
        return index;
    }

    private int height(TreeNode root){
        if (root == null){
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }
    private void helper(TreeNode root, List<Integer> ds, int level){
        if (root == null){
            return;
        }

        if (level == 1){
            ds.add(root.val);
        }
        if (level > 1){
            helper(root.left, ds, level - 1);
            helper(root.right, ds, level - 1);
        }
    }
}
