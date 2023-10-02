package LeetCode.bfs;

import LeetCode.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        List<Integer> res = new ArrayList<>();
        levelOrderHelper(root, res);
        System.out.println(res);
    }

    private static void levelOrderHelper(TreeNode root, List<Integer> res) {
        if (root == null){
            return;
        }
        Queue<TreeNode> dfsQueue = new LinkedList<>();
        dfsQueue.add(root);
        while (!dfsQueue.isEmpty()){
            int size = dfsQueue.size();
            //List<Integer> teempList = new ArrayList<>();
            for (int i=0; i<size; i++){
                TreeNode currNode = dfsQueue.remove();
                if (i == size - 1){
                    res.add(currNode.val);
                }
                if (currNode.left != null){
                    dfsQueue.add(currNode.left);
                }
                if (currNode.right != null){
                    dfsQueue.add(currNode.right);
                }
            }
            //int rightNode = teempList.get(teempList.size() - 1);
            //res.add(rightNode);
        }
    }
}
