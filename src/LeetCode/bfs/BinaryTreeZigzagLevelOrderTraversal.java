package LeetCode.bfs;

import LeetCode.tree.TreeNode;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> res = new ArrayList<>();
        zigzagLevelOrderHelper(root, res);
        System.out.println(res);
    }

    private static void zigzagLevelOrderHelper(TreeNode root, List<List<Integer>> res) {
        if (root == null){
            return;
        }
        Queue<TreeNode> dfsQueue = new LinkedList<>();
        dfsQueue.add(root);
        int level = 0;
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
            if (level % 2 != 0){
                Collections.reverse(teempList);
            }
            res.add(new ArrayList<>(teempList));
            level++;
        }
    }
}
