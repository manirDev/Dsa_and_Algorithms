package LeetcodeDaily.Week1_16_09_2024;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers {
    public static void main(String[] args) {
        int n = 100;
        List<Integer> res = helper(n);
        System.out.println(res);
    }
    private static List<Integer> lexicoHelper(int n) {
        List<Integer> res = new ArrayList<>();
        int curr = 1;
        for (int i = 0; i < n; i++) {
            res.add(curr);
            if (curr * 10 <= n) {
                curr *= 10;
            } else if (curr % 10 != 9 && curr + 1 <= n) {
                curr++;
            } else {
                while ((curr / 10) % 10 == 9) {
                    curr /= 10;
                }
                curr = curr / 10 + 1;
            }
        }

        return res;
    }
    private static List<Integer> helper(int n) {
        List<Integer> res = new ArrayList<>();
        int min = 1, max = 9;
        res.add(min);
        while (min <= max && min <= n) {
            for (int i = 2; i <= n; i++) {
                String s = String.valueOf(i);
                if (s.charAt(0) - '0' == min) {
                    int topNum = res.get(res.size() - 1);
                    if (String.valueOf(topNum).compareTo(s) < 0) {
                        res.add(i);
                    } else {
                        int idx = min;
                        while (idx < res.size()) {
                            if (String.valueOf(res.get(idx)).compareTo(s) > 0) {
                                break;
                            }
                            idx++;
                        }
                        res.add(idx, i);
                    }
                }
            }
            min++;
        }
        return res;
    }
}
