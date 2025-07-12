package LeetCodeCards.Graph.Unionfind;

public class QuickFind {
    int[] root;

    public QuickFind(int size){
        root = new int[size];
        for(int i=0; i<size; i++){
            root[i] = i;
        }
    }

    private int find(int node){
        return root[node];
    }

    private void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY){
            for (int i=0; i< root.length; i++){
                if (root[i] == rootY){
                    root[i] = rootX;
                }
            }
        }
    }

    private boolean isConnected(int x, int y){
        return find(x) == find(y);
    }
    public static void main(String[] args) {
        QuickFind unionFind = new QuickFind(10);
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
