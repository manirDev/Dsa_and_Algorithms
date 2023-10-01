package LeetCode.dfs;

import LeetCode.tree.TreeNode;
import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class SameTree {
    public static void main(String[] args) {
        /*---------First Tree----------------*/
        TreeNode firstTree = new TreeNode(1);
        firstTree.left = new TreeNode(2);
        firstTree.right = new TreeNode(3);
        /*---------Second Tree----------------*/
        TreeNode secondTree = new TreeNode(1);
        secondTree.left = new TreeNode(2);
        secondTree.right = new TreeNode(3);

        List<Integer> firstDfs = new ArrayList<>();
        List<Integer> secondDfs = new ArrayList<>();
        dfsHelper(firstTree, firstDfs);
        dfsHelper(secondTree, secondDfs);
        boolean res = firstDfs.equals(secondDfs);
        System.out.println(res);
        System.out.println(isSameTreeHelper(firstTree, secondTree));
    }

    private static void dfsHelper(TreeNode root, List<Integer> list) {
        if (root == null){
            return;
        }
        list.add(root.val);
        dfsHelper(root.left, list);
        dfsHelper(root.right, list);
    }
    private static boolean isSameTreeHelper(TreeNode firstTree, TreeNode secondTree){
        if (firstTree == null && secondTree == null){
            return true;
        }
        if (firstTree == null || secondTree == null){
            return false;
        }
        if (firstTree.val != secondTree.val){
            return false;
        }
        boolean left = isSameTreeHelper(firstTree.left, secondTree.left);
        boolean right = isSameTreeHelper(firstTree.right, secondTree.right);
        return left && right;
    }
}
