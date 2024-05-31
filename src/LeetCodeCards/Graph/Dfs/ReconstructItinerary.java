package LeetCodeCards.Graph.Dfs;

import LeetCodeCards.Graph.Graph;

import java.util.*;

public class ReconstructItinerary {
    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        //String[][] list = {{"MUC","LHR"},{"JFK","MUC"},{"SFO","SJC"},{"LHR","SFO"}};
        //String[][] list = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"}, {"ATL","SFO"}};
        String[][] list = {{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};
        for (String[] ele : list){
            tickets.add(Arrays.asList(ele));
        }
        Graph<String> graph = new Graph<>();
        buildGraph(graph, tickets);
        String source = "JFK";
        List<String> res = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        findItineraryHelper(graph, res, source, visited);
        System.out.println(res);
        System.out.println(graph.toString());
    }

    private static void findItineraryHelper(Graph<String> graph, List<String> res, String source, Set<String> visited) {
        while (graph.map.get(source) != null || !graph.map.get(source).isEmpty()){
            String adj = graph.map.get(source).remove(0);
            findItineraryHelper(graph, res, adj, visited);
        }
        res.add(0, source);
    }

    private static void buildGraph(Graph<String> graph, List<List<String>> tickets){
        for (int i=0; i<tickets.size(); i++){
            graph.addEdge(tickets.get(i).get(0), tickets.get(i).get(1), false);
            Collections.sort(graph.map.get(tickets.get(i).get(0)));
        }
    }
}
