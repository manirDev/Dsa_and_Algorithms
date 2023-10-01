package LeetCode.bfs;

import LeetCode.tree.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class TwoSumIV {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        int k = 9;
        boolean res = twoSumHelper(root, k);
        System.out.println(res);
    }

    private static boolean twoSumHelper(TreeNode root, int k) {
        if (root == null){
            return false;
        }
        Queue<TreeNode> dfsQueue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        dfsQueue.add(root);
        while (!dfsQueue.isEmpty()){
            TreeNode currNode = dfsQueue.remove();
            int temp = k - currNode.val;
            if (set.contains(temp)){
                return true;
            }
            set.add(currNode.val);
            if (currNode.left != null){
                dfsQueue.add(currNode.left);
            }
            if (currNode.right != null){
                dfsQueue.add(currNode.right);
            }
        }
        return false;
    }
}
