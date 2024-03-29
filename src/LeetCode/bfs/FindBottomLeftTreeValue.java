package LeetCode.bfs;

import LeetCode.tree.TreeNode;

import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;

public class FindBottomLeftTreeValue {
    public static void main(String[] args) {
        TreeNode root = new TreeNode( 1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.right = new TreeNode(7);
        int res =  findBottomLeftValueHelper(root);
        System.out.println(res);
    }

    private static int findBottomLeftValueHelper(TreeNode root) {
        if (root == null){
            return 0;
        }
        Queue<TreeNode> dfsQueue = new LinkedList<>();
        dfsQueue.add(root);
        int res = 0;
        while (!dfsQueue.isEmpty()){
            int size = dfsQueue.size();
            for (int i=0; i<size; i++){
                TreeNode currNode = dfsQueue.remove();
                if (i == 0){
                    res = currNode.val;
                }
                if (currNode.left != null){
                    dfsQueue.add(currNode.left);
                }
                if (currNode.right != null){
                    dfsQueue.add(currNode.right);
                }
            }
        }
        return res;
    }
}
