package LeetcodeDaily.Week2_23_09_2024;

import java.util.ArrayList;
import java.util.List;

public class MyCalendarI {
    List<int[]> intervals;
    public MyCalendarI(){
        intervals = new ArrayList<>();
    }
    public boolean book(int start, int end){
        for (int i=0; i<intervals.size(); i++){
            if(start < intervals.get(i)[1]  && end > intervals.get(i)[0]){
                return false;
            }
        }
        intervals.add(new int[]{start, end});
        return true;
    }
    public static void main(String[] args) {
        MyCalendarI myCalendarI = new MyCalendarI();
        System.out.println(myCalendarI.book(10, 20));
        System.out.println(myCalendarI.book(15, 25));
        System.out.println(myCalendarI.book(20,30));
    }
}
