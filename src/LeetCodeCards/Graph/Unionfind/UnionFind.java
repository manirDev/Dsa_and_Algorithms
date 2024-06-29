package LeetCodeCards.Graph.Unionfind;

public class UnionFind {
    int[] parent;
    public UnionFind(int size){
        parent = new int[size];
        for (int i=0; i<size; i++){
            parent[i] = i;
        }
    }
    public int find(int v){
        while (v != parent[v]){
            v = parent[v];
        }
        return v;
    }
    public void union(int x, int y){
        int parentX = find(x);
        int parentY = find(y);
        if (parentX != parentY){
            parent[parentX] = parentY;
        }
    }
    public boolean isConnected(int x, int y){
        return find(x) == find(y);
    }

    public static void main(String[] args) {
        UnionFind unionFind = new UnionFind(10);
        unionFind.union(1, 2);
        unionFind.union(2, 5);
        unionFind.union(5, 6);
        unionFind.union(6, 7);
        unionFind.union(3, 8);
        unionFind.union(8, 9);

        System.out.println(unionFind.isConnected(1, 5)); // true
        System.out.println(unionFind.isConnected(5, 7)); // true
        System.out.println(unionFind.isConnected(4, 9)); // false
        // 1-2-5-6-7 3-8-9-4
        unionFind.union(9, 4);
        System.out.println(unionFind.isConnected(4, 9)); // true
    }
}
