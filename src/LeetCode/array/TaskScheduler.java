package LeetCode.array;

import java.util.HashMap;
import java.util.Map;

public class TaskScheduler {
    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        int res = leastIntervalHelper(tasks, n);
        System.out.println(res);
    }

    private static int leastIntervalHelper(char[] tasks, int n) {
        int tasksLen = tasks.length;
        Map<Character, Integer> freqs = new HashMap<>();
        int maxFreq = Integer.MIN_VALUE;
        int numOfMaxFreq = 0;
        for (char task: tasks){
            freqs.put(task, freqs.getOrDefault(task, 0) + 1);
        }
        for (char key : freqs.keySet()){
            maxFreq = Math.max(maxFreq, freqs.get(key));
        }
        for (char key : freqs.keySet()){
            if (freqs.get(key) == maxFreq){
                numOfMaxFreq++;
            }
        }
        int cycle = n  + 1;
        int time = (maxFreq - 1) * cycle + numOfMaxFreq;
        return  Math.max(time, tasksLen);
    }
}
