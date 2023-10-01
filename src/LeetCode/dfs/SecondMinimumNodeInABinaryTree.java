package LeetCode.dfs;

import LeetCode.tree.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SecondMinimumNodeInABinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        Set<Integer> list = new HashSet<Integer>();
        secondMinimumNodeHelper(root, list);
        int min = Integer.MAX_VALUE;
        for (int e: list){
            if (e < min){
                min = e;
            }
        }
        int secondMin = Integer.MAX_VALUE;
        for (int e: list){
            if (e < secondMin && e != min){
                secondMin = e;
            }
        }
        System.out.println(secondMin);
    }

    private static void secondMinimumNodeHelper(TreeNode root, Set<Integer> list) {
        if (root == null){
            return;
        }
        list.add(root.val);
        secondMinimumNodeHelper(root.left, list);
        secondMinimumNodeHelper(root.right, list);
    }
}
