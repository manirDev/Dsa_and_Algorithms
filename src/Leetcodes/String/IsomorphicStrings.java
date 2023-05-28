package Leetcodes.String;

import java.util.HashMap;

/**
 Given two strings s and t, determine if they are isomorphic.
 Two strings s and t are isomorphic if the characters in s can be replaced to get t.

 All occurrences of a character must be replaced with another character while preserving
 the order of characters. No two characters may map to the same character, but a character may map to itself.

 Example 1:
 Input: s = "egg", t = "add"
 Output: true

 Example 2:
 Input: s = "foo", t = "bar"
 Output: false

 Example 3:
 Input: s = "paper", t = "title"
 Output: true
 **/
public class IsomorphicStrings {

    public static void main(String[] args) {
        String s = "paper", t = "title";
        if (isIsomorphic(s,t)){
            System.out.println("True");
        }else {
            System.out.println("False");
        }
    }

    public static boolean isIsomorphic(String s, String t){
        HashMap<Character, Character> mapper = new HashMap<>();
        int i=0;
        int j=0;
        while(i<s.length() && j<t.length()){
            if(mapper.containsKey(s.charAt(i))){
                if (mapper.get(s.charAt(i)) != t.charAt(j)){
                    return false;
                }
            }else {
                if (!mapper.containsValue(t.charAt(j))){
                    mapper.put(s.charAt(i), t.charAt(j));
                }else{
                    //we can not map two chars to the same char
                    return false;
                }
            }

            i++;
            j++;
        }

        return true;
    }
}
