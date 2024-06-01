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
        findItineraryHelper(graph, res, source);
        System.out.println(res);
    }

    private static void findItineraryHelper(Graph<String> graph, List<String> res, String source) {
        if (graph.map.get(source).size() > 0){
            List<String> adjs = graph.map.get(source);
            while(adjs.size() > 0){
                String adj = adjs.remove(0);
                findItineraryHelper(graph, res, adj);
            }

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
