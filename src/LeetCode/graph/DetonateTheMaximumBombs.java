package LeetCode.graph;

import java.util.*;

public class DetonateTheMaximumBombs {
    public static void main(String[] args) {
        int[][] bombs = {{1,1,5}, {10,10,5}};
        Map<Integer, List<Integer>> graph = new HashMap<>();
        buildGraph(graph, bombs);
        int max = Integer.MIN_VALUE;
        for (int vertex : graph.keySet()){
            max = Math.max(max, countComponentNodes(graph, vertex, new HashSet<>()));
        }
        System.out.println(graph);
        System.out.println(max);
    }

    private static  int countComponentNodes(Map<Integer, List<Integer>> graph, int source, Set<Integer> visited){
        if (visited.contains(source)){
            return 0;
        }

        visited.add(source);
        int count = 1;
        for (int adj : graph.get(source)){
            count += countComponentNodes(graph, adj, visited);
        }

        return count;
    }
    private static void buildGraph(Map<Integer, List<Integer>> graph, int[][] bombs){
        for (int v=0; v<bombs.length; v++){
            graph.put(v, new ArrayList<>());
        }

        for (int i=0; i<bombs.length; i++){
            for (int j=0; j<bombs.length; j++){
                if (i != j){
                    double dist = calculateDist(bombs[i][0], bombs[i][1], bombs[j][0], bombs[j][1]);
                    if (dist <= bombs[i][2]){
                        graph.get(i).add(j);
                    }
                }
            }
        }
    }

    private static double calculateDist(int x1, int y1, int x2, int y2){
        double dist1 = Math.pow((x1 - x2), 2);
        double dist2 = Math.pow((y1 - y2), 2);
        return Math.sqrt(dist1 + dist2);
    }
}
