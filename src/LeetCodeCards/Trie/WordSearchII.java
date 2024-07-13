package LeetCodeCards.Trie;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {
    static class Node{
        Node[] links;
        boolean flag;
        public Node() {
            links = new Node[26];
            flag = false;
        }

        public boolean contains(int charIndex) {
            return links[charIndex] != null;
        }

        public void put(int charIndex) {
            links[charIndex] = new Node();
        }

        public Node next(int charIndex) {
            return links[charIndex];
        }

        public void setEnd() {
            flag = true;
        }

        public boolean isEnd() {
            return flag;
        }
    }
    Node root;
    public WordSearchII(){
        root = new Node();
    }
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        for (String word : words){
            insert(word);
        }
        int row = board.length;
        int col = board[0].length;
        for (int i=0; i<row; i++){
            for (int j=0; j<col; j++){
                StringBuilder word = new StringBuilder();
                pathWord(board, i, j, root, res, word);
            }
        }
        return res;
    }

    private void pathWord(char[][] path, int r, int c, Node root, List<String> res, StringBuilder word){
        boolean rowInBounds = r >= 0 && r < path.length;
        boolean colInBounds = c >= 0 && c < path[0].length;
        if (!rowInBounds || !colInBounds || path[r][c] == '#') {
            return;
        }
        int charIndex = path[r][c] - 'a';
        if(!root.contains(charIndex)){
            return;
        }
        root = root.next(charIndex);
        word.append(path[r][c]);
        if(root.isEnd()){
            res.add(word.toString());
            root.flag = false;
        }

        char temp = path[r][c];
        path[r][c] = '#';
        pathWord(path, r+1, c, root, res, word);
        pathWord(path, r, c+1, root, res, word);
        pathWord(path, r-1, c, root, res, word);
        pathWord(path, r, c-1, root, res, word);
        path[r][c] = temp;
    }

    public void insert(String word){
        Node curr = root;
        for (char c : word.toCharArray()){
            int charIndex = c - 'a';
            if (!curr.contains(charIndex)){
                curr.put(charIndex);
            }
            curr = curr.next(charIndex);
        }
        curr.setEnd();
    }

    public static void main(String[] args) {
        WordSearchII wordSearch = new WordSearchII();
        char[][]  board = {
                            {'o','a','a','n'},
                            {'e','t','a','e'},
                            {'i','h','k','r'},
                            {'i','f','l','v'},
                        };
        String[] words = {"oath","pea","eat","rain"};
        List<String> res = wordSearch.findWords(board, words);
        System.out.println(res);
    }
}
