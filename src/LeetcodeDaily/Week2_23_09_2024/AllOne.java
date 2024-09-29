package LeetcodeDaily.Week2_23_09_2024;

import Libraries.Pair;

import java.util.HashMap;
import java.util.Map;

public class AllOne {
    private HashMap<String, Integer> allInOne;
    private Pair<String, Integer> maxKey;
    private Pair<String, Integer> minnKey;

    public AllOne() {
        allInOne = new HashMap<>();
        maxKey = new Pair<>("", Integer.MIN_VALUE);
        minnKey = new Pair<>("", Integer.MAX_VALUE);
    }

    public void inc(String key) {
        allInOne.put(key, allInOne.getOrDefault(key, 0) + 1);

        if (maxKey.getValue() <= allInOne.get(key)) {
            maxKey.setKey(key);
            maxKey.setValue(allInOne.get(key));
        }

        if (minnKey.getValue() >= allInOne.get(key)) {
            minnKey.setKey(key);
            minnKey.setValue(allInOne.get(key));
        } else if (minnKey.getKey().equals(key)) {
            int min = Integer.MAX_VALUE;
            for (Map.Entry<String, Integer> entry : allInOne.entrySet()) {
                if (entry.getValue() < min) {
                    minnKey.setKey(entry.getKey());
                    minnKey.setValue(entry.getValue());
                    min = entry.getValue();
                }
            }
        }
    }

    public void dec(String key) {
        if (allInOne.containsKey(key)) {
            allInOne.put(key, allInOne.get(key) - 1);
            if (allInOne.get(key) == 0) {
                allInOne.remove(key);
            }

            if (allInOne.isEmpty()) {
                maxKey.setKey("");
                maxKey.setValue(Integer.MIN_VALUE);
                minnKey.setKey("");
                minnKey.setValue(Integer.MAX_VALUE);
            } else {
                if (maxKey.getKey().equals(key)) {
                    int max = Integer.MIN_VALUE;
                    for (Map.Entry<String, Integer> entry : allInOne.entrySet()) {
                        if (entry.getValue() > max) {
                            maxKey.setKey(entry.getKey());
                            maxKey.setValue(entry.getValue());
                            max = entry.getValue();
                        }
                    }
                }

                if (minnKey.getKey().equals(key)) {
                    int min = Integer.MAX_VALUE;
                    for (Map.Entry<String, Integer> entry : allInOne.entrySet()) {
                        if (entry.getValue() < min) {
                            minnKey.setKey(entry.getKey());
                            minnKey.setValue(entry.getValue());
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

    public String getminnKey() {
        return minnKey.getKey();
    }

    public static void main(String[] args) {
        AllOne obj = new AllOne();
        obj.inc("key1");
        obj.inc("key2");
        obj.dec("key1");
        System.out.println("Max Key: " + obj.getMaxKey());
        System.out.println("minn Key: " + obj.getminnKey());
    }
}


