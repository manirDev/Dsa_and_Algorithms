package LeetcodeDaily.Week2_23_09_2024;

import Libraries.Pair;

import java.util.HashMap;
import java.util.Map;

public class AllOne {
    private HashMap<String, Integer> freq;
    private Pair<String, Integer> maxKey;
    private Pair<String, Integer> minKey;

    public AllOne() {
        freq = new HashMap<>();
        maxKey = new Pair<>("", Integer.MIN_VALUE);
        minKey = new Pair<>("", Integer.MAX_VALUE);
    }

    public void inc(String key) {
        freq.put(key, freq.getOrDefault(key, 0) + 1);

        if (maxKey.getValue() <= freq.get(key)) {
            maxKey.setKey(key);
            maxKey.setValue(freq.get(key));
        }

        if (minKey.getValue() >= freq.get(key)) {
            minKey.setKey(key);
            minKey.setValue(freq.get(key));
        } else if (minKey.getKey().equals(key)) {
            int min = Integer.MAX_VALUE;
            for (Map.Entry<String, Integer> entry : freq.entrySet()) {
                if (entry.getValue() < min) {
                    minKey.setKey(entry.getKey());
                    minKey.setValue(entry.getValue());
                    min = entry.getValue();
                }
            }
        }
    }

    public void dec(String key) {
        if (freq.containsKey(key)) {
            freq.put(key, freq.get(key) - 1);
            if (freq.get(key) == 0) {
                freq.remove(key);
            }

            if (freq.isEmpty()) {
                maxKey.setKey("");
                maxKey.setValue(Integer.MIN_VALUE);
                minKey.setKey("");
                minKey.setValue(Integer.MAX_VALUE);
            } else {
                if (maxKey.getKey().equals(key)) {
                    int max = Integer.MIN_VALUE;
                    for (Map.Entry<String, Integer> entry : freq.entrySet()) {
                        if (entry.getValue() > max) {
                            maxKey.setKey(entry.getKey());
                            maxKey.setValue(entry.getValue());
                            max = entry.getValue();
                        }
                    }
                }

                if (minKey.getKey().equals(key)) {
                    int min = Integer.MAX_VALUE;
                    for (Map.Entry<String, Integer> entry : freq.entrySet()) {
                        if (entry.getValue() < min) {
                            minKey.setKey(entry.getKey());
                            minKey.setValue(entry.getValue());
                            min = entry.getValue();
                        }
                    }
                }
            }
        }
    }

    public String getMaxKey() {
        return maxKey.getKey();
    }

    public String getMinKey() {
        return minKey.getKey();
    }

    public static void main(String[] args) {
        AllOne obj = new AllOne();
        obj.inc("key1");
        obj.inc("key2");
        obj.dec("key1");
        System.out.println("Max Key: " + obj.getMaxKey());
        System.out.println("minn Key: " + obj.getMinKey());
    }
}


