package DSA_LearningProcess.Arrays;

import java.util.ArrayList;
import java.util.List;

public class Players {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(6);
        list.add(2);
        list.add(3);
        list.add(5);
        int scoreDifference = getScoreDifference(list);
        System.out.println(scoreDifference);  // Output: 1
    }
    public static int getScoreDifference(List<Integer> numSeq) {
        int firstScore = 0;
        int secondScore = 0;

        for (int i = 0; i < numSeq.size(); i++) {
            if (i % 2 == 0) {
                firstScore += numSeq.get(i);
            }
            else {
                secondScore += numSeq.get(i);
                // Reverse the sequence if the removed number is even
                if (numSeq.get(i) % 2 == 0) {
                    reverseSequence(numSeq, i);
                }
            }
        }

        return firstScore - secondScore;
    }

    private static void reverseSequence(List<Integer> numSeq, int index) {
        int left = index + 1;
        int right = numSeq.size() - 1;

        while (left < right) {
            int temp = numSeq.get(left);
            numSeq.set(left, numSeq.get(right));
            numSeq.set(right, temp);
            left++;
            right--;
        }
    }
}
