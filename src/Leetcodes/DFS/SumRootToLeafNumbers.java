package Leetcodes.DFS;

import java.util.ArrayList;
import java.util.List;

public class SumRootToLeafNumbers {
    public static void main(String[] args) {
        // Create the binary tree manually
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        List<String> res = new ArrayList<>();
        helper(root, new StringBuilder(), res);
        int sum = 0;
        for (String s : res){
            sum = sum + Integer.valueOf(s);
        }
        System.out.println(sum);
    }

    private static void helper(TreeNode root, StringBuilder sb, List<String> temp){
        if (root == null){
            return;
        }
        sb.append(root.val);
        if (root.left==null && root.right==null){
            temp.add(sb.toString());
        }
        helper(root.left, sb, temp);
        helper(root.right,  sb, temp);
        sb.deleteCharAt(sb.length()-1);
    }
}
