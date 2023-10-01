package LeetCode.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
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
        List<Integer> res =  new ArrayList<>();
        inorderHelper(root, res);
        System.out.println(res);
    }

    private static void inorderHelper(TreeNode root, List<Integer> res) {
        if (root == null){
            return;
        }
        inorderHelper(root.left, res);
        res.add(root.val);
        inorderHelper(root.right, res);
    }
}
