package Leetcodes.Trees;

import Leetcodes.DFS.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class EvenOddTree {
//    A binary tree is named Even-Odd if it meets the following conditions:
//      The root of the binary tree is at level index 0, its children are at level index 1, their children are at level index 2, etc.
//      For every even-indexed level, all nodes at the level have odd integer values in strictly increasing order (from left to right).
//      For every odd-indexed level, all nodes at the level have even integer values in strictly decreasing order (from left to right).
//      Given the root of a binary tree, return true if the binary tree is Even-Odd, otherwise return false.
    public static void main(String[] args) {

    }
    public boolean isEvenOddTree(TreeNode root) {
        int treeHeight = height(root);
        List<List<Integer>> levels = new ArrayList<>();
        for (int i=1; i<=treeHeight; i++){
            List<Integer> temp = new ArrayList<>();
            helper(root, temp, i);
            levels.add(new ArrayList<>(temp));
        }

        for (int i=0; i<levels.size(); i++){
            if(levels.get(i).size() == 1){
                if((i % 2 == 0 && levels.get(i).get(0)%2==0) || (i % 2 != 0 && levels.get(i).get(0)%2!=0)){
                    return false;
                }
            }
            else{
                if ((i % 2 == 0 && !evenLevel(levels.get(i))) || (i % 2 !=0 && !oddLevel(levels.get(i)))){
                    return false;
                }
            }
        }
        return true;
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
    private boolean evenLevel(List<Integer> list){
        int i = 1;
        while (i < list.size()){
            if (list.get(i-1)>=list.get(i) || list.get(i) % 2 == 0){
                return false;
            }
            i++;
        }
        return true;
    }

    private boolean oddLevel(List<Integer> list){
        int i = 1;
        while (i < list.size()){
            if (list.get(i-1)<=list.get(i) || list.get(i) % 2 != 0){
                return false;
            }
            i++;
        }
        return true;
    }
}
