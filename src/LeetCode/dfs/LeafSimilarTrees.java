package LeetCode.dfs;

import LeetCode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(1);
        root1.left.left = new TreeNode(6);
        root1.left.right = new TreeNode(2);
        root1.right.left = new TreeNode(9);
        root1.right.right = new TreeNode(8);

        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(1);
        root2.left.left = new TreeNode(6);
        root2.left.right = new TreeNode(7);
        root2.right.left = new TreeNode(4);
        root2.right.right = new TreeNode(2);
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        isLeavesSameTrees(root1, list1);
        isLeavesSameTrees(root2, list2);
        System.out.println(list1.equals(list2));
    }

    private static void isLeavesSameTrees(TreeNode root, List<Integer> list) {
        if (root == null){
            return;
        }
        if (root.left == null && root.right == null){
            list.add(root.val);
        }
        isLeavesSameTrees(root.left, list);
        isLeavesSameTrees(root.right, list);
    }
}
