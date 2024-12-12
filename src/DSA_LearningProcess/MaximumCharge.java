package DSA_LearningProcess;

import java.util.PriorityQueue;

public class MaximumCharge {
    static class Element {
        int value;
        int index;

        Element(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
    public static int getMaximumCharge(int[] charge) {
        int n = charge.length;

        PriorityQueue<Element> pq = new PriorityQueue<>((a, b) -> a.value - b.value);

        for (int i = 0; i < n; i++) {
            pq.offer(new Element(charge[i], i));
        }

        boolean[] removed = new boolean[n];

        while (pq.size() > 2) {
            Element current = pq.poll();
            if (removed[current.index]) continue;

            // Mark this element as removed
            removed[current.index] = true;

            // Find the neighbors
            int left = current.index - 1;
            int right = current.index + 1;

            if (left >= 0 && right < n && !removed[left] && !removed[right]) {
                int combinedValue = charge[left] + charge[right];
                pq.offer(new Element(combinedValue, left));
                removed[right] = true;
            }
        }

        int maxCharge = 0;
        while (!pq.isEmpty()) {
            Element remaining = pq.poll();
            if (!removed[remaining.index]) {
                maxCharge = Math.max(maxCharge, remaining.value);
            }
        }

        return maxCharge;
    }


    public static void main(String[] args) {
        int[] charge = {-2, 9, 5, -2, 1, -9};
        System.out.println(getMaximumCharge(charge));
    }
}
