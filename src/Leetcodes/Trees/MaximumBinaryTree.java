package Leetcodes.Trees;

import Leetcodes.DFS.TreeNode;

public class MaximumBinaryTree {
    public static void main(String[] args) {

    }
    int index = 0;
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums, 0, nums.length);
    }

    private TreeNode helper(int[] nums, int start, int end){
        if (start > end){
            return null;
        }

        int maxIndex = findMax(nums, start, end);
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = helper(nums, start, maxIndex-1);
        root.right = helper(nums, maxIndex+1, end);
        return root;
    }
    private int findMax(int[] nums, int start, int end){
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        for(int i=start; i<=end; i++){
            if (nums[i] > max){
                max = nums[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
