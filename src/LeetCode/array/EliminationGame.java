package LeetCode.array;

import java.util.ArrayList;
import java.util.List;

public class EliminationGame {
    public static void main(String[] args) {
        int n = 9;
        List<Integer> list = new ArrayList<>();
        for (int i=1; i<=n ; i++){
            list.add(i);
        }

        eliminationGameHelper(list, 0, list.size() - 1, 'R');
        System.out.println(list.get(0));
    }

    private static List<Integer> eliminationGameHelper(List<Integer> list, int left, int right, char dir) {
        if (list.size() == 1 || left >= list.size() || right < 0){
            return list;
        }
        if (left <= list.size() - 1 && dir == 'R' && list.size() > 1){
            list.remove(left);
            eliminationGameHelper(list, left + 1, right, dir);
            right = list.size() - 1;
            left = 0;
            dir = 'L';
        }
       if (right >= 0 && dir == 'L' && list.size() > 1){
            list.remove(right);
            eliminationGameHelper(list, left, right - 2, dir);
            right = list.size() - 1;
            dir = 'R';
           eliminationGameHelper(list, left, right, dir);
        }
        return list;
    }
}
