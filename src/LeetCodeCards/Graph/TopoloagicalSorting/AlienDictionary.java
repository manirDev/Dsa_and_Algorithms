package LeetCodeCards.Graph.TopoloagicalSorting;

import LeetCode.bitManipulation.SingleNumber;

import java.sql.Array;
import java.util.*;

public class AlienDictionary {
    static class TopoNode{
        int inDegrees;
        List<Character> outNodes;
        public TopoNode(){
            inDegrees = 0;
            outNodes = new ArrayList<>();
        }
    }
    public static void main(String[] args) {
        String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
        String result = topoHelper(words);
        System.out.println(result);
    }

    private static String topoHelper(String[] words){
        Map<Character, TopoNode> graph = new HashMap<>();

        for (String word : words){
            for (char c : word.toCharArray()){
                graph.put(c, new TopoNode());
            }
        }

        for (int i=0; i<words.length - 1; i++){
            String w1 = words[i];
            String w2 = words[i + 1];
            if (w1.length() > w2.length() && w1.startsWith(w2)) {
                return "";
            }
            for (int j=0; j<Math.min(w1.length(), w2.length()); j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    graph.get(w2.charAt(j)).inDegrees++;
                    graph.get(w1.charAt(j)).outNodes.add(w2.charAt(j));
                }
            }
        }

        Queue<Character> topoQueue = new LinkedList<>();
        for (char c : graph.keySet()) {
            if (graph.get(c).inDegrees == 0){
                topoQueue.add(c);
            }
        }

        StringBuilder result = new StringBuilder();
        while(!topoQueue.isEmpty()){
            char currChar = topoQueue.poll();
            result.append(currChar);
            for (char nextChar : graph.get(currChar).outNodes){
                graph.get(nextChar).inDegrees--;
                if (graph.get(nextChar).inDegrees < 0){
                    return  "";
                }
                if (graph.get(nextChar).inDegrees == 0){
                    topoQueue.add(nextChar);
                }
            }
        }
        return result.toString();
    }
}
