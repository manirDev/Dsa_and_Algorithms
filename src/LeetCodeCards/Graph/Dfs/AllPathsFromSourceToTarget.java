package LeetCodeCards.Graph.Dfs;

import LeetCodeCards.Graph.Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AllPathsFromSourceToTarget {
    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {3}, {3}, {}};
        Graph<Integer> g = new Graph<>();
        constructGraph(g, graph);
        int source = 0, destination = graph.length - 1;
        List<List<Integer>> res = new ArrayList<>();
        allPathsSourceTargetHelper(g, res, new ArrayList<>(), source, destination);
        System.out.println(g.toString());
        System.out.println(res);
    }

    private static void allPathsSourceTargetHelper(Graph<Integer> g, List<List<Integer>> res, ArrayList<Integer> temp, int source, int destination) {
        temp.add(source);
        if (source == destination){
            //temp.add(destination);
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int adj : g.map.get(source)){
            //temp.add(adj);
            allPathsSourceTargetHelper(g, res, temp, adj, destination);
            temp.remove(temp.size() - 1);
        }
    }

    private static void constructGraph(Graph<Integer> g, int[][] graph){
        for (int i=0; i<graph.length; i++){
            for (int j=0; j<graph[i].length; j++){
                g.addEdge(i, graph[i][j], false);
            }
        }
    }
}
