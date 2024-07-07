package LeetCodeCards.Trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Currency;
import java.util.List;

public class PalindromePairs {
    static class Node{
        Node[] links;
        boolean flag;
        int index;
        List<Integer> palindromesBelow;

        public Node() {
            links = new Node[26];
            flag = false;
            index = -1;
            palindromesBelow = new ArrayList<>();
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

        public void setIndex(int idx) {
            index = idx;
        }

        public int getIndex() {
            return index;
        }
    }
    Node root;
    public PalindromePairs(){
        root = new Node();
    }
    public List<List<Integer>> palindromePairs(String[] words) {
        for (int i = 0; i < words.length; i++) {
            insert(words[i], i);
        }
        List<List<Integer>> pairs = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            pairs.addAll(search(words[i], i));
        }
        return pairs;
    }

    public void insert(String word, int index) {
        Node curr = root;
        for (int i = word.length() - 1; i >= 0; i--) {
            int charIndex = word.charAt(i) - 'a';
            if (isPalindrome(word, 0, i)) {
                curr.palindromesBelow.add(index);
            }
            if (!curr.contains(charIndex)) {
                curr.put(charIndex);
            }
            curr = curr.next(charIndex);
        }
        curr.setIndex(index);
        curr.setEnd();
        curr.palindromesBelow.add(index);
    }

    public List<List<Integer>> search(String word, int index) {
        List<List<Integer>> pairs = new ArrayList<>();
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            if (curr.isEnd() && isPalindrome(word, i, word.length() - 1)) {
                pairs.add(Arrays.asList(index, curr.getIndex()));
            }
            int charIndex = word.charAt(i) - 'a';
            if (!curr.contains(charIndex)) {
                return pairs;
            }
            curr = curr.next(charIndex);
        }
        for (int j : curr.palindromesBelow) {
            if (index != j) {
                pairs.add(Arrays.asList(index, j));
            }
        }
        return pairs;
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePairs palindromePairs = new PalindromePairs();
        //String[] words = {"abcd","dcba","lls","s","sssll"};
        //String[] words = {"bat","tab","cat"};
        String[] words = {"a",""};
        System.out.println(palindromePairs.palindromePairs(words));
    }
}
