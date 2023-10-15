package GeeksForGeeks.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DetectCycleInAnUndirectedGraph {
    public static void main(String[] args) {

    }

    private static boolean isCycleHelper(int V, ArrayList<ArrayList<Integer>> adj) {
        Set<Integer> visited = new HashSet<>();
        for (int v=0; v<V; v++){
            for (int source : adj.get(v)){
                if (isCyclic(adj, source, -1, visited)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isCyclic(ArrayList<ArrayList<Integer>> adj, int source, int parent, Set<Integer> visited) {
        if (!visited.contains(source)){
            visited.add(source);
            for (int neighbour : adj.get(source)){
                if (visited.contains(neighbour) && neighbour != parent){
                    return true;
                }
                if (isCyclic(adj, neighbour, source, visited)){
                    return true;
                }
            }
        }
        return false;
    }
}
