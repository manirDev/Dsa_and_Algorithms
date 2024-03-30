package LeetCode.graph;

import java.util.HashSet;
import java.util.Set;

public class FindIfPathExistsInGraph {
    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<>();
        int[][] edges = {{4,3},{1,4},{4,8},{1,7},{6,4},{4,2},{7,4},{4,0},{0,9},{5,4}};
        int n = 10, source = 5, destination = 9;
        buildGraphHelper(graph, edges, n);
        System.out.println(graph.toString());
        Set<Integer> visited = new HashSet<>();
        boolean res = isPathExistHelper(graph, visited, source, destination);
        System.out.println(res);
    }

    private static boolean isPathExistHelper(Graph<Integer> graph, Set<Integer> visited, int source, int destination) {
        if (source == destination){
            return true;
        }
        visited.add(source);
        for (int adj : graph.map.get(source)){
            if (!visited.contains(adj)){
                return isPathExistHelper(graph, visited, adj, destination);
            }
        }
        visited.remove(source);
        return false;
    }

    private static void buildGraphHelper(Graph<Integer> graph, int[][] edges, int n) {
        for (int i=0; i<n; i++){
            graph.addVertex(i);
        }
        for (int i=0; i<edges.length; i++){
            graph.addEdges(edges[i][0], edges[i][1], true);
        }
    }
}
