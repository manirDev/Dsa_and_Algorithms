package LeetCodeCards.Graph.Unionfind;

import java.util.*;

public class SmallestStringWithSwaps {
    public static class UnionFind{
        private int[] parent;
        private int[] rank;
        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        // Get the root of a vertex
        public int find(int x) {
            if (x == parent[x]) {
                return x;
            }
            return find(parent[x]);
        }

        // Perform the union of two components
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] >= rank[rootY]) {
                    parent[rootY] = rootX;
                    rank[rootX] += rank[rootY];
                } else {
                    parent[rootX] = rootY;
                    rank[rootY] += rank[rootX];
                }
            }
        }
    }
    public static void main(String[] args) {
        String s = "dcab";
        int[][] pairs = {{0,3},{1,2}};
        int n = s.length();
        char[] res = new char[n];
        UnionFind unionFind = new UnionFind(n);
        for (int i=0; i<pairs.length; i++){
            unionFind.union(pairs[i][0], pairs[i][1]);
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i=0; i<n; i++){
            int root = unionFind.find(i);
            map.putIfAbsent(root, new ArrayList<>());
            map.get(root).add(i);
        }
        for (int root : map.keySet()){
            List<Character> respectiveChars = new ArrayList<>();
            for (int idx : map.get(root)){
                respectiveChars.add(s.charAt(idx));
            }
            Collections.sort(respectiveChars);
            for (int i=0; i<map.get(root).size(); i++){
                res[map.get(root).get(i)] = respectiveChars.get(i);
            }
        }
        System.out.println(String.valueOf(res));
    }
}
