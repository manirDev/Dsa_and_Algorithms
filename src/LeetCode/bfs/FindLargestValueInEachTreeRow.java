package LeetCode.bfs;

import LeetCode.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindLargestValueInEachTreeRow {
    public static void main(String[] args) {
        TreeNode root =  new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left= new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(9);
        List<Integer> res = new ArrayList<>();
        largestValuesHelper(root, res);
        System.out.println(res);
    }

    private static void largestValuesHelper(TreeNode root, List<Integer> res) {
        if (root == null){
            return;
        }
        Queue<TreeNode> dfsQueue = new LinkedList<>();
        dfsQueue.add(root);
        while (!dfsQueue.isEmpty()){
            int size = dfsQueue.size();
            int tempMax = Integer.MIN_VALUE;
            for (int i=0; i<size; i++){
                TreeNode currNode = dfsQueue.remove();
                if (currNode.val > tempMax){
                    tempMax = currNode.val;
                }
                if (currNode.left != null){
                    dfsQueue.add(currNode.left);
                }
                if (currNode.right != null){
                    dfsQueue.add(currNode.right);
                }
            }
            res.add(tempMax);
        }
    }
}
