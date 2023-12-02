package LeetCode.tree;

import java.util.ArrayList;
import java.util.List;

public class FindLeavesOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        List<List<Integer>> res = new ArrayList<>();
        while (root.left != null || root.right != null){
            List<Integer> list = new ArrayList<>();
            findLeavesHelper(root, list);
            res.add(new ArrayList<>(list));
        }
        res.add(new ArrayList<>(List.of(root.val)));
        System.out.println(res);
    }

    private static TreeNode findLeavesHelper(TreeNode root, List<Integer> list) {
        if (root == null){
            return null;
        }
        if (root.left == null && root.right == null){
            list.add(root.val);
            root = null;
            return root;
        }
        root.left =  findLeavesHelper(root.left, list);
        root.right =  findLeavesHelper(root.right, list);
        return root;
    }
}
