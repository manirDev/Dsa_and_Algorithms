package LeetCode.bfs;

import LeetCode.tree.TreeNode;

import java.util.*;

public class AmountOfTimeForBinaryTreeToBeInfected {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(5);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(9);
        root.left.right.right = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(6);
        int start = 3;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        convertToUndirectedGraph(root, graph, 0);
        int res = amountOfTimeHelper(graph, start);
        System.out.println(res);
    }

    private static int amountOfTimeHelper(Map<Integer, List<Integer>> graph, int start) {
        Queue<Integer> bfsQueue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        int minutesToEffectAllNodes = 0;
        bfsQueue.add(start);
        visited.add(start);
        while (!bfsQueue.isEmpty()){
            int size = bfsQueue.size();
            for (int i=0; i<size; i++){
                int currentNode = bfsQueue.remove();
                for (int adjNode : graph.get(currentNode)){
                    if (!visited.contains(adjNode)){
                        bfsQueue.add(adjNode);
                        visited.add(adjNode);
                    }

                }
            }
            minutesToEffectAllNodes++;
        }
        return minutesToEffectAllNodes - 1;
    }

    private static void convertToUndirectedGraph(TreeNode root, Map<Integer, List<Integer>> graph, int parent) {
        if (root == null){
            return;
        }
        if (!graph.containsKey(root.val)){
            graph.put(root.val, new ArrayList<>());
        }
        List<Integer> adj = graph.get(root.val);
        if (parent != 0){
            adj.add(parent);
        }
        if (root.left != null){
            adj.add(root.left.val);
        }
        if (root.right != null){
            adj.add(root.right.val);
        }
        convertToUndirectedGraph(root.left, graph, root.val);
        convertToUndirectedGraph(root.right, graph, root.val);
    }
}
