package LeetCode.graph;

import java.util.Arrays;

public class MaxNumEdgesToRemove {
    public static class UnionFind{
        int[] parent;
        int counter;
        public UnionFind(int size) {
            parent = new int[size];
            counter = size;
            for (int i = 0; i < size; i++) {
                parent[i] = i + 1;
            }
        }

        public int find(int v) {
            while (v != parent[v-1]) {
                v = parent[v-1];
            }
            return v;
        }

        public void union(int x, int y) {
            int parentX = find(x);
            int parentY = find(y);
            if (parentX != parentY) {
                parent[parentX] = parentY;
                counter--;
            }
        }

        public int getUnionsNumber() {
            return counter;
        }
    }
    public static void main(String[] args) {
        int[][] edges = {{3, 1, 2}, {3, 2, 3}, {1, 1, 3}, {1, 2, 4}, {1, 1, 2}, {2, 3, 4}};
        int n = 4;
        int res = helper(edges, n);
        System.out.println(res);
    }
    private static int helper(int[][] edges, int n){
        UnionFind type_one = new UnionFind(n);
        UnionFind type_two = new UnionFind(n);
        UnionFind type_three = new UnionFind(n);
        int res = 0;

        for (int i=0; i<edges.length; i++){
            if (edges[i][0] == 3){
                type_three.union(edges[i][1], edges[i][2]);
            }
            if (edges[i][0] == 2){
                type_two.union(edges[i][1], edges[i][2]);
            }
            if (edges[i][0] == 1){
                type_one.union(edges[i][1], edges[i][2]);
            }
        }
        mergeRoot(type_three, type_two, n);
        mergeRoot(type_three, type_one, n);
        System.out.println(Arrays.toString(type_three.parent));
        return res;
    }

    private static void mergeRoot(UnionFind u1, UnionFind u2, int n){
        for (int i=0; i<n; i++){
            int x = i + 1;
            int type_three_root = u1.find(x);
            int type_two_root = u2.find(x);
            if (type_three_root == type_two_root || type_two_root == x){
                continue;
            }
            u1.union(type_three_root, type_two_root);
        }
    }
}
