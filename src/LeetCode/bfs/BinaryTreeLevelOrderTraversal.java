package LeetCode.bfs;

import LeetCode.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> res = new ArrayList<>();
        levelOrderHelper(root, res);
        System.out.println(res);
    }

    private static void levelOrderHelper(TreeNode root, List<List<Integer>> res) {
        if (root == null){
            return;
        }
        Queue<TreeNode> dfsQueue = new LinkedList<>();
        dfsQueue.add(root);
        while (!dfsQueue.isEmpty()){
            int size = dfsQueue.size();
            List<Integer> teempList = new ArrayList<>();
            for (int i=0; i<size; i++){
                TreeNode currNode = dfsQueue.remove();
                teempList.add(currNode.val);
                if (currNode.left != null){
                    dfsQueue.add(currNode.left);
                }
                if (currNode.right != null){
                    dfsQueue.add(currNode.right);
                }
            }
            res.add(new ArrayList<>(teempList));
        }
    }
}
