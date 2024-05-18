package LeetCode.heap;

import java.util.*;

public class TopKFrequentWords {
    public static void main(String[] args) {
        String[] words = {"the","day","is","sunny","the","the","the","sunny","is","is"};
        int k = 4;
        List<String> res = topKFrequentWordsHelper(words, k);
        System.out.println(res);

    }

    private static List<String> topKFrequentWordsHelper(String[] words, int k) {
        List<String> res = new ArrayList<>();
        PriorityQueue<String> heap;
        Map<String, Integer> freq = new HashMap<>();
        for (String word: words){
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }
        heap = new PriorityQueue<>(
                (a, b) -> freq.get(a).equals(freq.get(b)) ? b.compareTo(a) : freq.get(a) - freq.get(b)
        );
        for (String key : freq.keySet()){
            heap.add(key);
            if (heap.size() > k){
                heap.poll();
            }
        }
        for (int i=0; i<k; i++){
            res.add(heap.poll());
        }
        Collections.reverse(res);
        return res;
    }
}
