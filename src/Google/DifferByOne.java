package Google;

import java.util.HashMap;
import java.util.Map;

public class DifferByOne {
    public static void main(String[] args) {
        String[] dict = {"abcd","acbd", "aacd"};
        boolean res = differByOneHelper(dict);
        System.out.println(res);
    }

    private static boolean differByOneHelper(String[] dict) {
        int count = 0;
        for (int i=0; i<dict.length - 1; i++){
            Map<Integer, Character> map =new HashMap<>();
            for (int j=0; j<dict[i].length(); j++){
                map.put(j, dict[i].charAt(j));
            }
            int countDiff = 0;
            for (int j=0; j<dict[i+1].length(); j++){
                if (map.get(j) != dict[i+1].charAt(j)){
                    countDiff++;
                }
                if (countDiff > 1){
                    countDiff = 0;
                }
            }
            if (countDiff == 1){
                count++;
            }
        }
        return count > 0;
    }
}
