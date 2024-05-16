package LeetCodeCards.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph<T>{
    public Map<T, List<T>> map = new HashMap<>();

    public void addVertex(T vertex){
        map.put(vertex, new ArrayList<>());
    }
    public void addEdge(T source, T destination, boolean isBidirectional){
        if (!map.containsKey(source)){
            addVertex(source);
        }
        if (!map.containsKey(destination)){
            addVertex(destination);
        }
        map.get(source).add(destination);
        if (isBidirectional) {
            map.get(destination).add(source);
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (T vertex : map.keySet()){
            res.append(vertex + ":");
            for (T neighbor: map.get(vertex)){
                res.append(neighbor + " ");
            }
            res.append("\n");
        }
        return res.toString();
    }
}
