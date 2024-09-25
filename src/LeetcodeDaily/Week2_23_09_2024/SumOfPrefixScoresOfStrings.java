package LeetcodeDaily.Week2_23_09_2024;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Link{
    Link[] links;
    boolean end;
    int counter;
    public Link(){
        links = new Link[26];
        end = false;
    }
    public boolean contains(int charIdx){
        return links[charIdx] != null;
    }
    public void put(int charIdx){
        links[charIdx] = new Link();
    }
    public Link next(int charIdx) {
        return links[charIdx];
    }

    public boolean isEnd() {
        return end;
    }

    public void setEnd() {
        this.end = true;
    }
    public void increaseCounter() {
        counter++;
    }

    public int getCounter() {
        return counter;
    }
}
public class SumOfPrefixScoresOfStrings {
    Link root;
    public SumOfPrefixScoresOfStrings(){
        root = new Link();
    }

    public void insert(String word){
        Link curr = root;
        for (char c : word.toCharArray()){
            int charIdx = c - 'a';
            if (!curr.contains(charIdx)){
                curr.put(charIdx);
            }
            curr = curr.next(charIdx);
            curr.increaseCounter();
        }
        curr.setEnd();
    }

    public int getPrefixesSum(String word){
        Link curr = root;
        int count = 0;
        for (char c : word.toCharArray()){
            int charIdx = c - 'a';
            if (!curr.contains(charIdx)){
                break;
            }
            curr = curr.next(charIdx);
            count = count + curr.getCounter();
        }
        return count;
    }
    public static void main(String[] args) {
        String[] words = {"abc","ab","bc","b"};
        SumOfPrefixScoresOfStrings s = new SumOfPrefixScoresOfStrings();
        for (String word : words){
            s.insert(word);
        }
        int[] res = new int[words.length];
        int idx = 0;
        for (String word : words){
            res[idx] = s.getPrefixesSum(word);
            idx++;
        }
        System.out.println(Arrays.toString(res));
    }
}
