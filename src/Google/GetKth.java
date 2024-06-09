package Google;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class GetKth {
    public static void main(String[] args) {
        int lo = 12, hi = 15, k = 2;
        int res = getKthHelper(lo, hi, k);
        System.out.println(res);
    }

    private static int getKthHelper(int lo, int hi, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> heap;
        while (lo <= hi){
            int step = 0;
            int x = lo;
            while (x > 1){
                if (x % 2 == 0){
                    x = x / 2;
                    step++;
                }
                else{
                    x = 3*x + 1;
                    step++;
                }
            }

            map.put(lo, step);
            lo++;
        }
        heap = new PriorityQueue<>(
                (a, b) -> map.get(a).equals(map.get(b)) ? b.compareTo(a) : map.get(b) - map.get(a)
        );
        for (int key : map.keySet()){
            heap.add(key);
            if (heap.size() > k){
                heap.poll();
            }
        }

        return heap.poll();
    }
}
