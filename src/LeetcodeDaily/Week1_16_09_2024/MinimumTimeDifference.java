package LeetcodeDaily.Week1_16_09_2024;

import java.sql.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumTimeDifference {
    private static int MID_DAY = 12*60;
    private static int MID_NIGHT = 24*60;
    public static void main(String[] args) {
        List<String> timePoints = List.of("12:12","00:13");
        int res = helper(timePoints);
        System.out.println(res);
    }
    private static int helper(List<String> timePoints){
        List<Integer> timeInMin = convertIntoMinutes(timePoints);
        Collections.sort(timeInMin);
        int timeDiff = timeInMin.get(timeInMin.size() - 1) - timeInMin.get(0);
        int min = MID_NIGHT;
        if(timeDiff > MID_DAY){
            min = MID_NIGHT - timeDiff;
        }
        for (int i=0; i<timeInMin.size() - 1; i++){
            int diff = timeInMin.get(i + 1) - timeInMin.get(i);
            if (diff > MID_DAY){
                int tempDiff = MID_NIGHT - diff;
                min = Math.min(min, tempDiff);
            }
            else {
                min = Math.min(min, diff);
            }
        }
        return  min;
    }

    private static List<Integer> convertIntoMinutes(List<String> timePoints) {
        List<Integer> timeInMinutes = new ArrayList<>();
        for (String time : timePoints){
            String[] splitTime = time.split(":");
            int hour = Integer.valueOf(splitTime[0]);
            int min = Integer.valueOf(splitTime[1]);
            if(hour == 0){
                hour += 24;
            }
            int totalMin = hour * 60 + min;
            timeInMinutes.add(totalMin);
        }
        return   timeInMinutes;
    }
}
