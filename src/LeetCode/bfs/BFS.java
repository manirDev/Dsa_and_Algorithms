package LeetCode.bfs;

import LeetCode.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
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
        bfsHelper(root, res);
        System.out.println(res);
    }

    private static void bfsHelper(TreeNode root, List<Integer> res) {
        if (root == null){
            return;
        }
        Queue<TreeNode> bfsQueue = new LinkedList<>();
        bfsQueue.add(root);
        while (!bfsQueue.isEmpty()){
            TreeNode currentNode = bfsQueue.remove();
            res.add(currentNode.val);
            if (currentNode.left != null){
                bfsQueue.add(currentNode.left);
            }
            if (currentNode.right != null){
                bfsQueue.add(currentNode.right);
            }
        }
    }
}
