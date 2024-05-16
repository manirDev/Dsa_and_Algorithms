package LeetCodeCards.Graph.Dfs;

import LeetCodeCards.Graph.Graph;

import java.util.HashSet;
import java.util.Set;

public class FindIfPathExistsInGraph {
    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{0, 1}, {1, 2}, {2, 0}};
        int source = 0, destination = 2;
        Graph<Integer> graph = new Graph<>();
        Set<Integer> visited = new HashSet<>();
        constructGraphHelper(graph, edges, n);
        //System.out.println(graph.toString());
        boolean res  = isValidPathHelper(graph, visited, source, destination);
        System.out.println(res);
    }

    private static boolean isValidPathHelper(Graph<Integer> graph, Set<Integer> visited, int source, int destination) {
        if (source == destination){
            return true;
        }
        if (!visited.contains(source)){
            visited.add(source);
            for (int adj : graph.map.get(source)){
                if (isValidPathHelper(graph, visited, adj, destination)){
                    return true;
                }
            }
        }
        return false;
    }

    private static void constructGraphHelper(Graph<Integer> graph, int[][] edges, int n) {
        for (int i=0; i<edges.length; i++){
            graph.addEdge(edges[i][0], edges[i][1], true);
        }
    }
}
