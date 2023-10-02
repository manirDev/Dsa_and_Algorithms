package LeetCode.bfs;

import LeetCode.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class CousinInBinaryTreeV2 {
    public static class Pair{
        public TreeNode root;
        public TreeNode parent;

        public Pair(TreeNode root, TreeNode parent){
            this.root = root;
            this.parent = parent;
        }
    }
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
    private static boolean isCousinHelper(TreeNode root, int x, int y){
        if (root == null){
            return false;
        }
        Queue<Pair> dfsQueue = new LinkedList<>();
        dfsQueue.add(new Pair(root, null));
        while (!dfsQueue.isEmpty()){
            int size = dfsQueue.size();
            Pair xNode =  null;
            Pair yNode = null;
            for (int i=0; i<size; i++){
                Pair currPair = dfsQueue.remove();
                if (currPair.root.left != null){
                    dfsQueue.add(new Pair(currPair.root.left, currPair.root));
                }
                if (currPair.root.right != null){
                    dfsQueue.add(new Pair(currPair.root.right, currPair.root));
                }
            }
            for (Pair pair : dfsQueue){
                if (pair.root.val == x){
                    xNode = pair;
                }
                if (pair.root.val == y){
                    yNode = pair;
                }
            }
            if( (xNode != null && yNode == null) || (xNode == null && yNode != null)){
                return false;
            }
            if (xNode != null && yNode != null){
                return xNode.parent != yNode.parent;
            }
        }
        return false;
    }
}
