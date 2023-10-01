package LeetCode.bfs;

import LeetCode.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class CousinsInBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        int x = 4, y = 3;
        boolean res = isCousinHelper(root, x, y);
        System.out.println(res);
    }

    private static boolean isCousinHelper(TreeNode root, int x, int y) {
        if (root == null){
            return false;
        }
        Queue<TreeNode> dfsQueue = new LinkedList<>();
        dfsQueue.add(root);
        int xLevel = Integer.MAX_VALUE, yLevel = Integer.MIN_VALUE;
        int level = 0;
        while (!dfsQueue.isEmpty()){
            int size = dfsQueue.size();
            for (int i=0; i<size; i++){
                TreeNode currentNode = dfsQueue.remove();
                if (currentNode.left != null && currentNode.right != null){
                    if (currentNode.left.val == x && currentNode.right.val == y){
                        return false;
                    }
                    if (currentNode.left.val == y && currentNode.right.val == x){
                        return false;
                    }

                }
                if (currentNode.left != null){
                    dfsQueue.add(currentNode.left);
                }
                if (currentNode.right != null){
                    dfsQueue.add(currentNode.right);
                }
                if (currentNode.val == x){
                    xLevel = level;
                }
                if (currentNode.val == y){
                    yLevel = level;
                }
            }
            level++;
        }
        return xLevel == yLevel;
    }
}
