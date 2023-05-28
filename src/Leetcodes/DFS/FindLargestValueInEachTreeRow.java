package Leetcodes.DFS;

import java.util.ArrayList;
import java.util.List;

public class FindLargestValueInEachTreeRow {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);
        List<Integer> list = new ArrayList<>();
        helper(root, list, 0);
        System.out.println(list);
    }

    public static void helper(TreeNode root, List<Integer> list, int level) {
        if (root == null){
            return;
        }
        if (level==list.size()){
            list.add(root.val);
        }
        else{
            //to ensure largest value on level is being stored
            list.set(level, Math.max(list.get(level), root.val));
        }
        helper(root.left, list,level+1);
        helper(root.right, list, level+1);
    }
}
