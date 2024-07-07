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
                parent[i] = i;
            }
        }

        public int find(int v) {
            while (v != parent[v]) {
                v = parent[v];
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
        UnionFind type_one = new UnionFind(n + 1);
        UnionFind type_two = new UnionFind(n + 1);
        UnionFind type_three = new UnionFind(n + 1);
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
        System.out.println(Arrays.toString(type_three.parent));
        res = mergeRoot(type_three, type_two, n);
        System.out.println(res);
        mergeRoot(type_three, type_one, n);
        System.out.println(Arrays.toString(type_three.parent));
        return res;
    }

    private static int mergeRoot(UnionFind u1, UnionFind u2, int n){
        int res = 0;
        for (int i=1; i<=n; i++){
            int type_three_root = u1.find(i);
            int type_two_root = u2.find(i);
            if (type_three_root == type_two_root || type_two_root == i){
                continue;
            }
            //u1.union(type_three_root, type_two_root);
            u1.parent[type_three_root] = type_two_root;
            res++;
        }
        return res;
    }
}
