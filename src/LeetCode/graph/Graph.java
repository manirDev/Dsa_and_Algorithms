package LeetCode.graph;

import java.util.*;

public class Graph<T> {
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

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (T s : map.keySet()){
            sb.append(s + " : [ ");
            for(T adj : map.get(s)){
                sb.append( adj + " ");
            }
            sb.append("]\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<>();
//        graph.addEdges(0, 1, true);
//        graph.addEdges(0, 4, true);
//        graph.addEdges(1, 2, true);
//        graph.addEdges(1, 3, true);
//        graph.addEdges(1, 4, true);
//        graph.addEdges(2, 3, true);
//        graph.addEdges(3, 4, true);
        int[][] matrix = {
                {1,1,0,0,0},
                {1,1,1,1,0},
                {0,1,1,1,0},
                {0,1,1,1,0},
                {0,0,0,0,1}
        };
        for (int i=0; i<matrix.length; i++){
            graph.map.put(i, new LinkedList<>());
        }
        for (int i=0; i<matrix.length; i++){
            for (int j=0; j<matrix[i].length; j++){
                if (matrix[i][j] == 1 && i != j){
                  if (!graph.isEdgeExist(i, j)){
                      graph.addEdges(i, j, true);
                  }
                }
            }
        }
        System.out.println("Graph : \n" + graph.toString());
    }
}
