package LeetCode.bfs;

import LeetCode.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class EvenOddTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(10);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(12);
        root.left.left.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.right.right.left = new TreeNode(6);
        root.right.right.right = new TreeNode(2);

        boolean res = isEvenOddTreeHelper(root);
        System.out.println(res);
    }

    private static boolean isEvenOddTreeHelper(TreeNode root) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> dfsQueue = new LinkedList<>();
        //List<List<Integer>> list = new ArrayList<>();
        dfsQueue.add(root);
        int level = 0;
        while (!dfsQueue.isEmpty()){
            int size = dfsQueue.size();
            List<Integer> tempList = new ArrayList<>();
            for (int i=0; i<size; i++){
                TreeNode currNode = dfsQueue.remove();
                tempList.add(currNode.val);
                if (currNode.left!=null){
                    dfsQueue.add(currNode.left);
                }
                if (currNode.right!=null){
                    dfsQueue.add(currNode.right);
                }
            }
            if (level % 2 == 0 && !isEvenLevel(tempList)){
                return false;
            }
            if (level % 2 != 0 && !isOddLevel(tempList)){
                return false;
            }
            level++;
        }
        return true;
    }
    private static boolean isEvenLevel(List<Integer> list){
        for (int ele : list){
            if (ele % 2 == 0){
                return false;
            }
        }
        for (int i=0; i<list.size()-1; i++){
            if (list.get(i)>=list.get(i+1)){
                return false;
            }
        }
        return true;
    }
    private static boolean isOddLevel(List<Integer> list){
        for (int ele : list){
            if (ele % 2 != 0){
                return false;
            }
        }
        for (int i=0; i<list.size()-1; i++){
            if (list.get(i)<=list.get(i+1)){
                return false;
            }
        }
        return true;
    }
}
