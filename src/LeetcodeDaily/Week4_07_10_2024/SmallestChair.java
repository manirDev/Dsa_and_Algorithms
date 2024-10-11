package LeetcodeDaily.Week4_07_10_2024;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SmallestChair {
    public static void main(String[] args) {
        int[][] times = {{1,4},{2,3},{4,6}};
        int targetFriend = 1;
        int res = helper(times, targetFriend);
        System.out.println(res);
    }
    private static int helper(int[][] times, int targetFriend){
        for (int i = 0; i < times.length; i++) {
            times[i] = new int[] {times[i][0], times[i][1], i};
        }
        Arrays.sort(times, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> emptySeats = new PriorityQueue<>();
        PriorityQueue<int[]> occupiedSeats = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));


        for (int i = 0; i < times.length; i++) {
            emptySeats.add(i);
        }

        for (int[] friend : times) {
            int arrivalTime = friend[0];
            int leavingTime = friend[1];
            int friendIndex = friend[2];

            while (!occupiedSeats.isEmpty() && occupiedSeats.peek()[0] <= arrivalTime) {
                emptySeats.add(occupiedSeats.poll()[1]);
            }

            int currEmptySeat = emptySeats.poll();
            if (friendIndex == targetFriend) {
                return currEmptySeat;
            }

            occupiedSeats.add(new int[] {leavingTime, currEmptySeat});
        }

        return -1;
    }
}
