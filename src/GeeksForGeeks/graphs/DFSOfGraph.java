package GeeksForGeeks.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DFSOfGraph {
    public static void main(String[] args) {

    }
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> res = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        dfsOfGraphHelper(adj, 0, res, visited);
        return res;
    }

    private void dfsOfGraphHelper(ArrayList<ArrayList<Integer>> adj, int source, ArrayList<Integer> res, Set<Integer> visited) {
        if (visited.contains(source)){
            return;
        }
        res.add(source);
        visited.add(source);
        for (int neighbour : adj.get(source)){
            dfsOfGraphHelper(adj, neighbour, res, visited);
        }
    }
}
