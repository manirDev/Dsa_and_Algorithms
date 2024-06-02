package LeetCodeCards.Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeadsToDestination {
    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {0, 2}};
        int source = 0, destination = 2;
        int n = 3;
        boolean[] visited = new boolean[n];
        ArrayList<Integer>[] graph = buildGraphHelper(edges, n);
        boolean res = leadsToDestinationHelper(graph, visited, source, destination);
        System.out.println(res);
    }

    private static boolean leadsToDestinationHelper(ArrayList<Integer>[] graph, boolean[] visited, int source, int destination) {
        if(graph[source] == null || graph[source].size() == 0){
            return source == destination;
        }
        visited[source] = true;
        for (int neighbour : graph[source]){
            if (visited[neighbour] || !leadsToDestinationHelper(graph, visited, neighbour, destination)){
                return false;
            }
        }
        visited[source] = false;
        return true;
    }
    private static ArrayList<Integer>[] buildGraphHelper(int[][] edges, int n) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i=0; i<n; i++){
            graph[i]  = new ArrayList<>();
        }
        for(int i=0; i<edges.length; i++){
            graph[edges[i][0]].add(edges[i][1]);
        }
        return graph;
    }
}
