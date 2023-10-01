package LeetCode.bfs;

import LeetCode.tree.TreeNode;
import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<Double> res = new ArrayList<>();
        levelAverageHelper(root, res);
        System.out.println(res);
    }

    private static void levelAverageHelper(TreeNode root, List<Double> res) {
        if (root == null){
            return;
        }
        Queue<TreeNode> dfsQueue = new LinkedList<>();
        dfsQueue.add(root);
        List<List<Integer>> list = new ArrayList<>();
        while(!dfsQueue.isEmpty()){
            int size = dfsQueue.size();
            double sum = 0.0;
            for (int i=0; i<size; i++){
                TreeNode currNode =  dfsQueue.remove();
                sum = sum + currNode.val;
                if (currNode.left != null){
                    dfsQueue.add(currNode.left);
                }
                if (currNode.right != null){
                    dfsQueue.add(currNode.right);
                }
            }
            res.add(sum/size);
        }
    }
}
