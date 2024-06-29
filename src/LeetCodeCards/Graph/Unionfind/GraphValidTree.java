package LeetCodeCards.Graph.Unionfind;

public class GraphValidTree {
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
        int[][] edges = {{0,1},{0,2},{0,3},{1,4}};
        int n = 5;
        UnionFind unionFind = new UnionFind(n);
        for (int i=0; i<edges.length; i++){
            int xRoot = unionFind.find(edges[i][0]);
            int yRoot = unionFind.find(edges[i][1]);
            if (xRoot == yRoot){
                System.out.println(false);
                break;
            }
            unionFind.union(edges[i][0], edges[i][1]);
        }
        System.out.println(true);
    }
}
