package LeetCode.tree;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class KthSmallestElementInABT {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        int k = 1;
        List<Integer> res = new ArrayList<>();
        kthSmallestHelper(root, res, k);
        System.out.println(res.get(k -1));
    }

    private static void kthSmallestHelper(TreeNode root, List<Integer> res, int k) {
        if (root == null){
            return;
        }
        kthSmallestHelper(root.left, res, k);
        res.add(root.val);
        kthSmallestHelper(root.right, res, k);
    }
    private static int kthSmallestHelperIter(TreeNode root, int k){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        int counter = 0;
        while (temp!=null && !stack.isEmpty()){
            while (temp != null){
                stack.push(temp);
                temp = temp.left;
            }
            TreeNode currNode = stack.pop();
            counter++;
            if (counter == k){
                return currNode.val;
            }
            currNode = currNode.right;
        }
        return 0;
    }
}
