package LeetCode.recursion;

import LeetCode.linkedList.ListNode;
import LeetCode.tree.TreeNode;
import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {
    public static void main(String[] args) {
        int n = 3;
        List<TreeNode> res = generateBSTHelper(1, n);
        for (TreeNode root : res){
            root.preorder(root);
            System.out.println();
        }
    }

    private static List<TreeNode> generateBSTHelper(int left, int right) {
       List<TreeNode> res = new ArrayList<>();
        if (left > right){
            res.add(null);
            return res;
        }
        for (int idx=left; idx<=right; idx++){
            List<TreeNode> leftTree = generateBSTHelper(left, idx - 1);
            List<TreeNode> rightTree = generateBSTHelper(idx + 1, right);
            for (TreeNode leftRoot : leftTree){
                for (TreeNode rightRoot : rightTree){
                    TreeNode root = new TreeNode(idx);
                    root.left = leftRoot;
                    root.right = rightRoot;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
