package LeetCodeCards.Graph.Bfs;

import LeetCodeCards.Graph.Graph;

import java.beans.Visibility;
import java.sql.Array;
import java.util.*;

public class AllPathsFromSourceToTarget {
    public static void main(String[] args) {
        int[][] graph = {{4,3,1},{3,2,4},{3},{4},{}};
        int source = 0;
        int destination = graph.length - 1;
        Graph<Integer> adjList = new Graph<>();
        buildAdjListHelper(adjList, graph);
        List<List<Integer>> res = allPathHelper(adjList, source, destination);
        System.out.println(res);
        System.out.println(adjList.toString());
    }

    private static void buildAdjListHelper(Graph<Integer> adjList, int[][] graph) {
        for (int i=0; i<graph.length; i++){
            for (int j=0; j<graph[i].length; j++){
                adjList.addEdge(i, graph[i][j], false);
            }
        }
    }

    private static List<List<Integer>> allPathHelper(Graph<Integer> adjList, int source, int destination) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<List<Integer>> bfsQueue = new LinkedList<>();
        bfsQueue.add(List.of(source));
        while(!bfsQueue.isEmpty()){
            List<Integer> path = bfsQueue.remove();
            int node = path.get(path.size()-1);
            if(node == destination){
                res.add(new ArrayList<>(path));
            }
            for(int neighbour : adjList.map.get(node)){
                List<Integer> tempPath = new ArrayList<>(path);
                tempPath.add(neighbour);
                bfsQueue.add(tempPath);
            }
        }
        return res;
    }
}
