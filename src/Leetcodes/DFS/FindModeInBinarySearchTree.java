package Leetcodes.DFS;

import java.util.*;

public class FindModeInBinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        //root.left = new TreeNode(1);
        //root.left.left = new TreeNode(0);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(2);
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        helper(root, map);
        int maxFreq = 0;
        for (int k : map.keySet()) {
            maxFreq = Math.max(maxFreq, map.get(k));
        }
        for(int k : map.keySet()){
            if (maxFreq == map.get(k)){
                result.add(k);
            }
        }
        int[] arr = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            arr[i] = result.get(i);
        }
        System.out.println(result);
    }

    public static void helper(TreeNode root, HashMap<Integer, Integer> map) {
        if (root == null){
            return;
        }

        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        helper(root.left, map);
        helper(root.right, map);

    }
}
