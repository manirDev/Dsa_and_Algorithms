package LeetCodeCards.Graph.Unionfind;

public class CountComponents {
    public static class UnionFind{
        public int[] ids;
        public int unionCount;
        public UnionFind(int size){
            unionCount = size;
            ids = new int[size];
            for(int i=0; i<size; i++){
                ids[i] = i;
            }
        }
        public int find(int node){
            return ids[node];
        }
        public void union(int x, int y) {
            int xId = find(x);
            int yId = find(y);
            if (xId == yId){
                return;
            }
            for (int i=0; i<ids.length; i++){
                if (ids[i] == xId){
                    ids[i] = yId;
                }
            }
            unionCount--;
        }
        public int getUnionCount(){
            return  unionCount;
        }
    }
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0,1},{1,2},{3,4}};
        UnionFind unionFind = new UnionFind(n);
        for (int i=0; i<edges.length; i++){
            unionFind.union(edges[i][0], edges[i][1]);
        }
        System.out.println(unionFind.getUnionCount());
    }
}
