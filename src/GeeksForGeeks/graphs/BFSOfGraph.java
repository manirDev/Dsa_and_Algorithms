package GeeksForGeeks.graphs;

import java.util.*;

public class BFSOfGraph {
    public static void main(String[] args) {

    }
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> res = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> bfsQueue = new LinkedList<>();
        bfsQueue.add(0);
        visited.add(0);
        while (!bfsQueue.isEmpty()){
            int current = bfsQueue.remove();
            res.add(current);
            for (int neighbour : adj.get(current)){
                if (!visited.contains(neighbour)){
                    bfsQueue.add(neighbour);
                    visited.add(neighbour);
                }
            }
        }
        return res;
    }
}
