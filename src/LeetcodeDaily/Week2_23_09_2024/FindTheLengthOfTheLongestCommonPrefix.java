package LeetcodeDaily.Week2_23_09_2024;

import LeetCodeCards.Trie.TrieNode;

class PrefixTree {
    PrefixTree[] links;
    boolean end;

    public PrefixTree() {
        this.links = new PrefixTree[10];
        this.end = false;
    }

    public boolean contains(int digit) {
        return links[digit] != null;
    }

    public void put(int digit) {
        links[digit] = new PrefixTree();
    }

    public PrefixTree next(int digit) {
        return links[digit];
    }

    public void setEnd() {
        end = true;
    }

    public boolean isEnd() {
        return end;
    }

}

public class FindTheLengthOfTheLongestCommonPrefix {
    private PrefixTree root;
    public FindTheLengthOfTheLongestCommonPrefix(){
        root = new PrefixTree();
    }
    private void insert(String num){
        PrefixTree curr = root;
        for (char c : num.toCharArray()){
            if (!curr.contains(c - '0')){
                curr.put(c - '0');
            }
            curr = curr.next(c - '0');
        }
        curr.setEnd();
    }
    public int getLongestPrefix(String num) {
        PrefixTree curr = root;
        int currLen = 0;
        for (char c : num.toCharArray()) {
            if (!curr.contains(c - '0')) {
                break;
            }
            currLen++;
            curr = curr.next(c - '0');
        }
        return currLen;
    }
    public static void main(String[] args) {
        int[] arr1 = {123, 456, 789};
        int[] arr2 = {123, 789, 456};
        FindTheLengthOfTheLongestCommonPrefix s = new FindTheLengthOfTheLongestCommonPrefix();
        for (int num : arr2) {
            s.insert(String.valueOf(num));
        }

        int res = Integer.MIN_VALUE;
        for (int num : arr1) {
            res = Math.max(res, s.getLongestPrefix(String.valueOf(num)));
        }
        System.out.println(res);
    }
}
