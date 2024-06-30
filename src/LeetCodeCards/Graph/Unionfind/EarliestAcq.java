package LeetCodeCards.Graph.Unionfind;

import java.util.Arrays;
import java.util.Comparator;

public class EarliestAcq {
    public static class UnionFind{
        int[] parent;
        int unionCount;
        public UnionFind(int size){
            unionCount = size;
            parent = new int[size];
            for (int i=0; i<size; i++){
                parent[i] = i;
            }
        }
        public int find(int x){
            if (x == parent[x]){
                return x;
            }
            return find(parent[x]);
        }
        public void union(int x,int y){
            int xRoot = find(x);
            int yRoot = find(y);
            if (xRoot != yRoot){
                parent[xRoot] = yRoot;
                unionCount--;
            }
        }
        public int getUnionCount(){
            return unionCount;
        }
    }
    public static void main(String[] args) {
        //int[][] logs = {{20190101,0,1},{20190104,3,4},{20190107,2,3},{20190211,1,5},{20190224,2,4},{20190301,0,3},{20190312,1,2},{20190322,4,5}};
        int[][] logs = {{0, 2, 0}, {1, 0, 1}, {3, 0, 3}, {4, 1, 2}, {7, 3, 1}};
        int n = 4;
        UnionFind unionFind = new UnionFind(n);
        Arrays.sort(logs, new Comparator<int[]>() {
            @Override
            public int compare(int[] log1, int[] log2) {
                return Integer.compare(log1[0], log2[0]);
            }
        });
        for (int i=0; i<logs.length; i++){
            unionFind.union(logs[i][1], logs[i][2]);
            if(unionFind.getUnionCount() == 1){
                System.out.println(logs[i][0]);
                break;
            }
        }
    }
}
