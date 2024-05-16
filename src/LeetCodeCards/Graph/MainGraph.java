package LeetCodeCards.Graph;

public class MainGraph {
    public static void main(String[] args) {
        Graph<Character> graph = new Graph<>();
        graph.addEdge('A', 'B', true);
        graph.addEdge('A', 'C', true);
        graph.addEdge('C', 'B', true);
        System.out.println(graph.toString());
    }
}
