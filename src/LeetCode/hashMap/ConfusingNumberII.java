package LeetCode.hashMap;

import java.util.*;

public class ConfusingNumberII {

    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        int n = 20;
        int res = confusingNumberHelper(n);
        System.out.println(res);
        System.out.println(list.toString());
    }

    private static int confusingNumberHelper(int n) {
//        Map<Character, Character> map = new HashMap<>();
//        int res = 0;
//        map.put('0', '0');
//        map.put('1', '1');
//        map.put('6', '9');
//        map.put('8', '8');
//        map.put('9', '6');
//        for(int i=1; i<=n; i++){
//            String s = String.valueOf(i);
//            boolean isValid = true;
//            StringBuilder sb = new StringBuilder();
//            for (char ch : s.toCharArray()) {
//                if (!map.containsKey(ch)) {
//                    isValid = false;
//                    break;
//                }
//                else{
//                    sb.append(map.get(ch));
//                }
//            }
//            if (isValid) {
//                sb.reverse();
//                if (!sb.toString().equals(s)) {
//                    res++;
//                }
//            }
//        }
//        return res;
        Map<Character, Character> rotateMap = new HashMap<>();
        rotateMap.put('0', '0');
        rotateMap.put('1', '1');
        rotateMap.put('6', '9');
        rotateMap.put('8', '8');
        rotateMap.put('9', '6');

        Queue<Long> queue = new LinkedList<>();
        queue.add(0L);

        int count = 0;

        while (!queue.isEmpty()) {
            long num = queue.poll();
            if (num > n) continue;

            if (num != 0 && isConfusing(num, rotateMap)) {
                count++;
            }

            for (char digit : rotateMap.keySet()) {
                if (num == 0 && digit == '0') continue; // Skip leading zero
                long nextNum = num * 10 + (digit - '0');
                if (nextNum > 0 && nextNum <= n) {
                    queue.add(nextNum);
                }
            }
        }

        return count;
    }

    private static boolean isConfusing(long num, Map<Character, Character> rotateMap) {
        String original = String.valueOf(num);
        StringBuilder rotated = new StringBuilder();
        for (char ch : original.toCharArray()) {
            rotated.append(rotateMap.get(ch));
        }
        rotated.reverse();
        return !original.equals(rotated.toString());
    }
}


//[6,9,10,16,18,19]