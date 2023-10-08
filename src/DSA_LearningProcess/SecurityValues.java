package DSA_LearningProcess;

import java.util.*;

public class SecurityValues {
    public static void main(String[] args) {
        int[] security_values = {1,2,1,3,1,3,5,7,1,1,5,5,8,10,11,1,23,2,3,7,8,9,1,6,5,9};
        //int[] security_values = {2,2,1,1,2,1,1,1,1,1,2,2,2,2,2,2,2,1,2,1,2,1,1,2,1,1};
        String msg  = "afeb";
        int c = 0;
        int res = getMinHelper(security_values, msg);
        //System.out.println(c);
        System.out.println(res);
    }

    private static int getMinHelper(int[] securityValues, String msg) {
        Integer min = Integer.MAX_VALUE;
        int sum = 0;
        String alphabets = "abcdefghijklmnopqrstuvwxyz";
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0; i<alphabets.length(); i++){
            map.put(alphabets.charAt(i), securityValues[i]);
        }
        List<Integer> list = new ArrayList<>();
        int j = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()){
            if (entry.getKey() == msg.charAt(j)){
                list.add(entry.getValue());
                j++;
            }
        }
        Collections.sort(list);
        for (int i=0; i<list.size() - 1; i++){
            sum += Math.abs(list.get(i) - list.get(i+1));
        }
        return sum;
    }
}
