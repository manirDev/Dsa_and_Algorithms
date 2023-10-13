package LeetCode.graph;

import java.util.*;

public class NumberOfProvinces {
    private static class Graph<T> {
        public Map<T, List<T>> map = new HashMap<>();

        public void addVertex(T v){
            map.put(v,  new LinkedList<T>());
        }

        public void addEdges(T source, T destination, boolean isBidirectional){
            if (!map.containsKey(source)){
                addVertex(source);
            }
            if (!map.containsKey(destination)){
                addVertex(destination);
            }
            map.get(source).add(destination);
            if (isBidirectional){
                map.get(destination).add(source);
            }
        }

        public boolean isEdgeExist(T s, T d){
            if (map.containsKey(s)){
                if (map.get(s).contains(d)){
                    return true;
                }
            }
            return false;
        }

    }
    public static void main(String[] args) {
        int[][] isConnected = {
                                {1,1,0},
                                {1,1,0},
                                {0,0,1}
                              };
        Graph<Integer> graph = new Graph<>();
        graphConstructHelper(graph, isConnected);
        int res = findCircleNumHelper(graph);
        System.out.println(res);
    }

    private static int findCircleNumHelper(Graph<Integer> graph) {
        int count = 0;
        Set<Integer> visited = new HashSet<>();
        for (int source : graph.map.keySet()){
            if (traverseHelper(graph, source, visited)){
                count++;
            }
        }
        return count;
    }

    private static boolean traverseHelper(Graph<Integer> graph, int source, Set<Integer> visited) {
        if (visited.contains(source)){
            return false;
        }
        visited.add(source);
        for (int adj : graph.map.get(source)){
            traverseHelper(graph, adj, visited);
        }
        return true;
    }

    private static void graphConstructHelper(Graph<Integer> graph, int[][] isConnected) {
        for (int i=0; i<isConnected.length; i++){
            graph.map.put(i, new LinkedList<>());
        }
        for (int i=0; i<isConnected.length; i++){
            for (int j=0; j<isConnected[i].length; j++){
                if (isConnected[i][j] == 1 && i != j){
                    if (!graph.isEdgeExist(i, i)){
                        graph.addEdges(i, j, true);
                    }

                }
            }
        }
    }


}
