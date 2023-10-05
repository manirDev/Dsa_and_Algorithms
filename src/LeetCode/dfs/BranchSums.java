package LeetCode.dfs;

import LeetCode.tree.TreeNode;

import javax.swing.tree.TreeCellRenderer;
import java.util.ArrayList;
import java.util.List;

public class BranchSums {
    //public static int sum = 0;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        List<Integer> res = new ArrayList<>();
        branchSumsHelper(root, res, 0);
        System.out.println(res);
    }

    private static void branchSumsHelper(TreeNode root, List<Integer> res, int sum) {
        if (root == null){
            return;
        }
        sum  = sum + root.val;
        if (root.left == null && root.right == null){
            res.add(sum);
            return;
        }
        branchSumsHelper(root.left, res, sum);
        branchSumsHelper(root.right, res, sum);
    }
}
