package Search.BinarySearch.V2;

import java.util.Arrays;

public class BSAonStrings {
    public static void main(String[] args) {
        String strings[] ={"EIASFSFSFSB","BB","AA","SDFSFJ","WRTG","FF","ERF","FED","TGH"};
        String search = "BB";
        Arrays.sort(strings);
        System.out.println(Arrays.toString(strings));
        System.out.println("BSA Array of String: " + helper(strings, search));
        String string = "abcdefg";
        char target = 'f';
        System.out.println("BSA String: " + helperChar(string, target));
    }

    private static int helper(String[] strings, String search) {
        int s = 0;
        int e = strings.length - 1;
        while (s <= e){
            int mid = s + (e - s)/2;
            if (strings[mid].equals(search)){
                return mid;
            }
            else if (strings[mid].compareTo(search) < 0){
                s = mid + 1;
            }
            else {
                e = mid - 1;
            }
        }
        return -1;
    }
    private static int helperChar(String string, char target) {
        int s = 0;
        int e = string.length() - 1;
        while (s <= e){
            int mid = s + (e - s)/2;
            if (string.charAt(mid) == target){
                return mid;
            }
            else if (string.charAt(mid) < target){
                s = mid + 1;
            }
            else {
                e = mid - 1;
            }
        }
        return -1;
    }
}
