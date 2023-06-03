package Leetcodes.Trees;

import Leetcodes.DFS.TreeNode;

public class ConvertSortedArrayToBinarySearch {
    public static void main(String[] args) {

    }
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = new TreeNode();
        root = helper(nums, 0, nums.length);
        return root;
    }
    private TreeNode helper(int[] arr, int start, int end){
        if (start > end){
            return null;
        }
        int mid = start + (end - start)/2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = helper(arr, start, mid-1);
        root.right = helper(arr, mid+1, end);
        return root;
    }
}
