package LeetCode.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class AdjList {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        ArrayList<Integer> node = new ArrayList<>();
        adj.add(node);

        node = new ArrayList<>();
        node.add(2);
        node.add(3);
        adj.add(node);

        node = new ArrayList<>();
        node.add(1);
        node.add(4);
        node.add(5);
        adj.add(node);

        node = new ArrayList<>();
        node.add(1);
        node.add(4);
        adj.add(node);

        node = new ArrayList<>();
        node.add(2);
        node.add(3);
        node.add(5);
        adj.add(node);

        node = new ArrayList<>();
        node.add(2);
        node.add(4);
        adj.add(node);

        System.out.println(adj);
    }
}
