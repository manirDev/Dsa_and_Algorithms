package LeetCode.bfs;

import LeetCode.tree.TreeNode;
import com.sun.source.tree.Tree;

import java.util.*;

public class LowestCommonAncestorOfABinaryTree {
    public static void main(String[] args) {
        TreeNode root= new TreeNode(3);
        root.left = new TreeNode(5);
//        root.right = new TreeNode(1);
//        root.left.left = new TreeNode(6);
//        root.left.right = new TreeNode(2);
//        root.left.right.left = new TreeNode(7);
//        root.left.right.right = new TreeNode(4);
//        root.right.left = new TreeNode(0);
//        root.right.right = new TreeNode(8);
        TreeNode p = root.left;
        TreeNode q = root.left.left;
        TreeNode res = lcaHelper(root, p, q);
        System.out.println(res.val);
    }

    private static TreeNode lcaHelper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return null;
        }
        Queue<TreeNode> bfsQueue = new LinkedList<>();
        HashMap<TreeNode, List<TreeNode>> map = new HashMap<>();
        bfsQueue.add(root);
        map.put(root, new ArrayList<>());
        while (!bfsQueue.isEmpty()){
            int size = bfsQueue.size();
            for (int i=0; i<size; i++){
                TreeNode currNode = bfsQueue.remove();
                if (currNode.left != null){
                    bfsQueue.add(currNode.left);
                    List<TreeNode> left = new ArrayList<>();
                    left.add(currNode);
                    left.addAll(map.get(currNode));
                    map.put(currNode.left, new ArrayList<>(left));
                }
                if (currNode.right != null){
                    bfsQueue.add(currNode.right);
                    List<TreeNode> right = new ArrayList<>();
                    right.add(currNode);
                    right.addAll(map.get(currNode));
                    map.put(currNode.right, new ArrayList<>(right));
                }
            }
        }
        Set<TreeNode> res = new HashSet<>(map.get(p));
        for (int i=0; i<map.get(q).size(); i++){
            if (map.get(p).contains(q)){
                return q;
            }
            if (map.get(q).contains(p)){
                return p;
            }
            if (res.contains(map.get(q).get(i))){
                return map.get(q).get(i);
            }
            res.add(map.get(q).get(i));
        }
        return null;
    }
}
