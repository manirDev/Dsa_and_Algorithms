package LeetCodeCards.Trie;


public class MapSum {
    private TrieNode root;
    public MapSum(){
        root = new TrieNode(0);
    }

    public void insert(String key, int val) {
        int wordValue = getWordValue(key);
        TrieNode curr = root;
        for (char c : key.toCharArray()){
            int charIndex = c - 'a';
            if (!curr.contains(charIndex)){
                curr.put(charIndex, val);
            }
            else{
                curr.setCharValue(charIndex, val, wordValue);
            }
            curr = curr.next(charIndex);
        }
        curr.setEnd();
        curr.setWordValue(val);
    }

    public int sum(String prefix) {
        TrieNode curr = root;
        for (char c : prefix.toCharArray()) {
            int charIndex = c - 'a';
            if (!curr.contains(charIndex)){
                return 0;
            }
            curr = curr.next(charIndex);;
        }
        return curr.getCharValue();
    }
    public int getWordValue(String word){
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int charIndex = c - 'a';
            if (!curr.contains(charIndex)){
                return 0;
            }
            curr = curr.next(charIndex);;
        }
        return curr.isEnd() ? curr.getWordValue() : 0;
    }

    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        System.out.println(mapSum.sum("ap"));
        mapSum.insert("app", 2);
        System.out.println(mapSum.sum("ap"));

    }
}
