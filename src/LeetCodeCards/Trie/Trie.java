package LeetCodeCards.Trie;

class Node{
    Node[] links;
    boolean flag;

    public Node(){
        links = new Node[26];
        flag = false;
    }
    public boolean contains(int charIndex){
        return  links[charIndex] != null;
    }
    public void put(int charIndex){
        links[charIndex] = new Node();
    }
    public Node next(int charIndex){
        return links[charIndex];
    }
    public void setEnd(){
        flag = true;
    }
    public boolean isEnd(){
        return flag;
    }
}
public class Trie {
    Node root;

    public Trie(){
        root = new Node();
    }

    public void insert(String word){
        Node curr = root;
        for (int i=0; i<word.length(); i++){
            int charIndex = word.charAt(i) - 'a';
            if (!curr.contains(charIndex)){
                curr.put(charIndex);
            }
            curr = curr.next(charIndex);
        }
        curr.setEnd();
    }

    public boolean search(String word){
        Node curr = root;
        for (int i=0; i<word.length(); i++){
            int charIndex = word.charAt(i) - 'a';
            if (!curr.contains(charIndex)){
                return false;
            }
            curr = curr.next(charIndex);
        }
        return curr.isEnd();
    }

    public boolean startWith(String prefix){
        Node curr = root;
        for (int i=0; i<prefix.length(); i++){
            int charIndex = prefix.charAt(i) - 'a';
            if (!curr.contains(charIndex)){
                return false;
            }
            curr = curr.next(charIndex);
        }
        return true;
    }

    public static void main(String[] args) {
        Node trie = new Node();
    }
}
