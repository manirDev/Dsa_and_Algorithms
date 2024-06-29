package LeetCodeCards.Graph.Unionfind;

import LeetCode.graph.Graph;

public class NumberOfProvinces {
    public static class UnionFind {
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
        int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
        UnionFind unionFind = new UnionFind(isConnected.length);
        for (int i=0; i<isConnected.length; i++){
            for (int j=0; j<isConnected.length; j++){
                if (isConnected[i][j] == 1){
                    unionFind.union(i, j);
                }
            }
        }
        int res = unionFind.getUnionsNumber();
        System.out.println(res);
    }

}
