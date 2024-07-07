package LeetCodeCards.Trie;


import java.util.ArrayList;
import java.util.List;

public class ReplaceWords {
    private Node root;
    public ReplaceWords(){
        root = new Node();
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        for (String word : dictionary){
            insert(word);
        }
        String[] words = sentence.split(" ");
        StringBuilder res = new StringBuilder();
        for (String word : words){
            String ans = search(word);
            res.append(ans + " ");
        }
        res.deleteCharAt(res.length() - 1);
        return res.toString();
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
    public String search(String word){
        Node curr = root;
        StringBuilder ans = new StringBuilder();
        for (char c : word.toCharArray()){
            int charIndex = c - 'a';
            if (curr.contains(charIndex)){
                ans.append(c);
                if (curr.links[charIndex].isEnd()){
                    return ans.toString();
                }
            }
            if (!curr.contains(charIndex)){
                return word;
            }

            curr = curr.next(charIndex);
        }
        return ans.toString();
    }
    public static void main(String[] args) {
        ReplaceWords replaceWords = new ReplaceWords();
        //String[] dict = {"cat","bat","rat"};
        String[] dict = {"a","b","c"};
        //String sentence = "the cattle was rattled by the battery";
        String sentence = "aadsfasf absbs bbab cadsfafs";
        List<String> dictionary = new ArrayList<>(List.of(dict));
        String res = replaceWords.replaceWords(dictionary, sentence);
        System.out.println(res);
    }
}
