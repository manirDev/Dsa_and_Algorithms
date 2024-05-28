package LeetCodeCards.Graph.Dfs;

import LeetCodeCards.Graph.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReconstructItinerary {
    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        String[][] list = {{"MUC","LHR"},{"JFK","MUC"},{"SFO","SJC"},{"LHR","SFO"}};
        for (String[] ele : list){
            tickets.add(Arrays.asList(ele));
        }
        System.out.println(tickets);
        Graph<String> graph = new Graph<>();
        buildGraph(graph, tickets);
        System.out.println(graph.toString());
    }
    private static void buildGraph(Graph<String> graph, List<List<String>> tickets){

    }
}
