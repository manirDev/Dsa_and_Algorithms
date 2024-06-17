package LeetCodeCards.Graph.Bfs;

import LeetCodeCards.Graph.Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.zip.ZipFile;

public class FindIfPathExistsInGraph {
    public static void main(String[] args) {
        int[][] edges = {{0,1},{0,2},{3,5},{5,4},{4,3}};
        int n = 3;
        int source = 0, destination = 5;
        Graph<Integer> graph = new Graph<>();
        buildGraphHelper(graph, edges);
        boolean res = isValidPathHelper(graph, source, destination);
        System.out.println(res);
        System.out.println(graph.toString());
    }
    private static void buildGraphHelper(Graph<Integer> graph, int[][] edges){
        for (int i=0; i<edges.length; i++){
            graph.addEdge(edges[i][0], edges[i][1], true);
        }
    }
    private static boolean isValidPathHelper(Graph<Integer> graph, int source, int destination){
        Queue<Integer> bfsQueue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        bfsQueue.add(source);
        visited.add(source);
        while (!bfsQueue.isEmpty()){
            int node = bfsQueue.remove();
            for (int neighbour : graph.map.get(node)){
                if (!visited.contains(neighbour)){
                    visited.add(neighbour);
                    bfsQueue.add(neighbour);
                }
                if (neighbour == destination){
                    return true;
                }
            }
        }
        return false;
    }
}
