package Leetcodes.Trees;

import Leetcodes.DFS.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {

    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        int treeHeight = height(root);
        List<List<Integer>> result = new ArrayList<>();
        for(int i=1; i<=treeHeight; i++){
            List<Integer> tempList = new ArrayList<>();
            helper(root, tempList, i);
            result.add(new ArrayList<>(tempList));
        }
        return result;
    }

    private int height(TreeNode root){
        if (root == null){
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }
    private void helper(TreeNode root,List<Integer> tempList, int level){
        if (root == null){
            return;
        }
        if (level == 1){
            tempList.add(root.val);
        }
        if(level > 1){
            helper(root.left, tempList, level - 1);
            helper(root.right, tempList, level - 1);
        }
    }

}
