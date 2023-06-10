package Leetcodes.Trees;

import Leetcodes.DFS.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class AverageOfLevelsInBinaryTree {
    public static void main(String[] args) {

    }

    public List<Double> averageOfLevels(TreeNode root) {
        int treeHeight = height(root);
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> levels = new ArrayList<>();
        for (int i=1; i<treeHeight; i++){
            helper(root, list, i);
            levels.add(new ArrayList<>(list));
        }
        List<Double> res = new ArrayList<>();
        for (int i=0; i<levels.size(); i++){
            int sum = 0;
            for (int j=0; j<levels.get(0).size(); j++){
                sum = sum + levels.get(i).get(j);
            }
            res.add((double)sum/levels.get(0).size());
        }
        return res;
    }

    private int height(TreeNode root){
        if (root==null){
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }
    private void helper(TreeNode root, List<Integer> list, int level){
        if (root == null){
            return;
        }
        if (level == list.size()){
            list.set(level, list.get(level) + root.val);
        }

        if (level > 1){
            helper(root.left, list, level+1);
            helper(root.right, list, level+1);
        }
    }
}
