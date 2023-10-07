package LeetCode.bfs;

import LeetCode.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class DeepestLeavesSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode( 1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(7);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(6);
        root.right.right.right = new TreeNode(8);
        int res = deepestLeavesSumHelper(root);
        System.out.println(res);
    }

    private static int deepestLeavesSumHelper(TreeNode root) {
        if (root == null){
            return 0;
        }
        Queue<TreeNode> dfsQueue = new LinkedList<>();
        dfsQueue.add(root);
        int res = 0;
        while (!dfsQueue.isEmpty()){
            int size = dfsQueue.size();
            int tempSum = 0;
            for (int i=0; i<size; i++){
                TreeNode currNode = dfsQueue.remove();
                tempSum += currNode.val;
                if (currNode.left != null){
                    dfsQueue.add(currNode.left);
                }
                if (currNode.right != null){
                    dfsQueue.add(currNode.right);
                }
            }
            res = tempSum;
        }
        return res;
    }
}
