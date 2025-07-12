package LeetCodeCards.Graph.Unionfind;

public class QuickUnion {
    int[] root;

    public QuickUnion(int size){
        root = new int[size];
        for(int i=0; i<size; i++){
            root[i] = i;
        }
    }

    private int find(int node){
        while(node != root[node]){
            node = root[node];
        }
        return node;
    }

    private void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY){
            root[rootY] = rootX;
        }
    }

    private boolean isConnected(int x, int y){
        return  find(x) == find(y);
    }

    public static void main(String[] args) {
        QuickUnion unionFind = new QuickUnion(10);
        unionFind.union(1, 2);
        unionFind.union(2, 5);
        unionFind.union(5, 6);
        unionFind.union(6, 7);
        unionFind.union(3, 8);
        unionFind.union(8, 9);

        System.out.println(unionFind.isConnected(1, 5)); // true
        System.out.println(unionFind.isConnected(5, 7)); // true
        System.out.println(unionFind.isConnected(4, 9)); // false

        unionFind.union(4, 9);
        System.out.println(unionFind.isConnected(9, 4)); // true
    }
}
