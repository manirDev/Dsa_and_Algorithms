package Leetcodes.DFS;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        System.out.println(list);
    }
    public static void helper(TreeNode root, List<Integer> list) {
        if (root==null){
            return;
        }
        list.add(root.val);
        helper(root.right, list);
    }
}
