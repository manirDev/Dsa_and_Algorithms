package Leetcodes.DFS;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

    public static void main(String[] args) {
        // Create the binary tree manually
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        int targetSum = 22;
        List<List<Integer>> res = new ArrayList<>();
        helper(root, targetSum, new ArrayList<>(), res);
        for (List<Integer> l : res){
            System.out.println(l);
        }
    }

    private static void helper(TreeNode root, int targetSum, List<Integer> temp, List<List<Integer>> list){
          if (root == null){
              return;
          }
          temp.add(root.val);
          if (root.left==null && root.right==null){
              targetSum -= root.val;
              if (targetSum == 0){
                  list.add(new ArrayList<>(temp));
              }
          }
          helper(root.left, targetSum - root.val, temp, list);
          helper(root.right, targetSum - root.val, temp, list);
          temp.remove(temp.size()-1);
    }
}
