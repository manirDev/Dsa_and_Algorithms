package LeetCodeCards.Trie;

public class TrieNode{
    TrieNode[] links;
    boolean end;
    int charValue;
    int wordValue;
    public TrieNode(int val){
        this.links = new TrieNode[26];
        this.end = false;
        this.charValue = val;
        this.wordValue = 0;
    }
    public boolean contains(int charIndex){
        return  links[charIndex] != null;
    }
    public void put(int charIndex, int val){
        links[charIndex] = new TrieNode(val);
    }
    public TrieNode next(int charIndex){
        return links[charIndex];
    }
    public void setEnd(){
        end = true;
    }
    public boolean isEnd(){
        return end;
    }
    public void setCharValue(int charIndex,int val, int wordValue){
        links[charIndex].charValue += (val - wordValue);
    }
    public int getCharValue(){
        return charValue;
    }
    public void setWordValue(int val){
        wordValue = val;
    }
    public int getWordValue(){
        return wordValue;
    }
}
