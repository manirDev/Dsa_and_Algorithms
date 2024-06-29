package LeetCode.graph;

import java.sql.Array;
import java.util.*;

public class GetAncestors {
    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<>();
        //int[][] edges = {{0,3},{0,4},{1,3},{2,4},{2,7},{3,5},{3,6},{3,7},{4,6}};
        int[][] edges = {{3, 6}, {2, 4}, {8, 6}, {7, 4}, {1, 4}, {2, 1}, {7, 2}, {0, 4}, {5, 0}, {4, 6}, {3, 2}, {5, 6}, {1, 6}};
        int n = 9;
        buildGraphHelper(graph, edges, n);
        List<List<Integer>> res = new ArrayList<>();
        getAncestorsHelper(graph, res, n);
        System.out.println(res);
        System.out.println(graph.toString());
    }

    private static void getAncestorsHelper(Graph<Integer> graph, List<List<Integer>> res, int n) {
        for (int i = 0; i < n; i++) {
            res.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            findAncestors(graph, res, i, i, visited);
        }

        for (List<Integer> ancestors : res) {
            Collections.sort(ancestors);
        }

    }

    private static void findAncestors(Graph<Integer> graph, List<List<Integer>> res, int start, int node, boolean[] visited) {
        if (visited[node]) {
            return;
        }
        visited[node] = true;
        for (int neighbor : graph.map.get(node)) {
            if (!res.get(neighbor).contains(start)) {
                res.get(neighbor).add(start);
            }
            findAncestors(graph, res, start, neighbor, visited);
        }

        visited[node] = false;
    }

    private static void buildGraphHelper(Graph<Integer> graph, int[][] edges, int n) {
        for (int i=0; i<n; i++){
            graph.addVertex(i);
        }
        for (int[] edge : edges) {
            graph.addEdges(edge[0], edge[1], false);
        }
    }
}
