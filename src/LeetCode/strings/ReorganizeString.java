package LeetCode.strings;

import java.util.ArrayList;
import java.util.List;

public class ReorganizeString {
    public static void main(String[] args) {
        String str = "kkkkzrkatkwpkkkktrq";
        List<String> list = new ArrayList<>();
        reorganizeHelper(str, new StringBuilder(), list, new boolean[str.length()]);
        if (list.size() > 0)
            System.out.println(list.get(0));
        System.out.println("");
    }

    private static void reorganizeHelper(String str, StringBuilder res, List<String> list, boolean[] visited) {
        if (res.length() == str.length()){
            StringBuilder temp = new StringBuilder();
            for (int i=0; i<res.length(); i++){
                if (i>0 && res.charAt(i) == res.charAt(i-1)){
                    break;
                }
                temp.append(res.charAt(i));
            }
            if (temp.length() == str.length()){
                list.add(temp.toString());
            }
            return;
        }

        for (int i=0; i<str.length(); i++){
            if (visited[i] == true){
                continue;
            }
            if (i > 0 && !visited[i-1] && str.charAt(i) == str.charAt(i-1)){
                continue;
            }
            visited[i] = true;
            res.append(str.charAt(i));
            reorganizeHelper(str, res, list, visited);
            res.deleteCharAt(res.length() - 1);
            visited[i] = false;
        }
    }
}
