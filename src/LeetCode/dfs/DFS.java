package LeetCode.dfs;

import LeetCode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class DFS {
    public static void main(String[] args) {
        TreeNode root =  new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.right.right.left = new TreeNode(8);
        root.right.right.right = new TreeNode(9);

        List<Integer> res = new ArrayList<>();
        dfsHelper(root, res);
        System.out.println(res);
    }

    private static void dfsHelper(TreeNode root, List<Integer> res) {
        if (root == null){
            return;
        }
        res.add(root.val);
        dfsHelper(root.left, res);
        dfsHelper(root.right, res);
    }
}
