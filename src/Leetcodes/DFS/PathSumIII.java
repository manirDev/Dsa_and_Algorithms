package Leetcodes.DFS;

import java.util.ArrayList;
import java.util.List;

public class PathSumIII {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);
        int targetSum = 8;
        List<Integer> list = new ArrayList<>();
        System.out.println( helper(root, targetSum, list));
    }
    private static int helper(TreeNode root, long targetSum, List<Integer> temp){
        if (root==null){
            return 0;
        }
        temp.add(root.val);
        int counter = 0;
        long sum = 0;
        // find the sums of all sub-paths ending at the current node i=temp.size()-1 because we check from current node;
        for (int i= temp.size()-1; i>=0; i--){
            sum = sum + temp.get(i);
            if (sum==targetSum){
                counter++;
            }
        }
        counter = counter + helper(root.left, targetSum , temp);
        counter = counter + helper(root.right, targetSum , temp);
        temp.remove(temp.size() - 1);

        return counter;
    }
}
