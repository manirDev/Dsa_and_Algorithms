package Leetcodes.DFS;

import java.util.ArrayList;
import java.util.List;

public class FlattenBinaryTreeToLinkedList {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        List<TreeNode> res = new ArrayList<>();
        TreeNode head = root;
        helper(head, res);
        for (int i=1; i< res.size(); i++) {
            root.right = res.get(i);
            root.left = null;
            root = root.right;
        }

    }
    private static void helper(TreeNode root, List<TreeNode> list) {
        if (root==null) return;
        list.add(root);
        helper(root.left, list);
        helper(root.right, list);
    }
}
