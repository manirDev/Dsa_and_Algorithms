package LeetCodeCards.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphImplementation<T> {
    Map<T, List<T>> map = new HashMap<>();

    void addVertex(T vertex){
        map.put(vertex, new ArrayList<>());
    }

    void addEdge(T source, T destination, boolean isBidirectional){
        if (!map.containsKey(source)){
            addVertex(source);
        }
        if (!map.containsKey(destination)){
            addVertex(destination);
        }
        if (isBidirectional){
            map.get(destination).add(source);
        }

        map.get(source).add(destination);
    }
    public static void main(String[] args) {

    }
}
