package LeetcodeDaily.Week2_23_09_2024;

import java.util.ArrayList;
import java.util.List;

public class MyCalendarII {
    List<int[]> intervals;
    List<int[]> doubleIntersections;
    public MyCalendarII() {
        intervals = new ArrayList<>();
        doubleIntersections = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (int[] doubleIntersection : doubleIntersections){
            if (start < doubleIntersection[1] && end > doubleIntersection[0]){
                return false;
            }
        }
        for (int[] interval : intervals) {
            if (start < interval[1] && end > interval[0]) {
                doubleIntersections.add(new int[] {Math.max(start, interval[0]), Math.min(end, interval[1])});
            }
        }

        intervals.add(new int[]{start, end});
        return true;
    }
    public static void main(String[] args) {

    }
}
