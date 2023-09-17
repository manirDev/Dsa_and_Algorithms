package LeetCode.hashSet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class intersection {
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        System.out.println(Arrays.toString(helper(nums1, nums2)));
    }
    private static int[] helper(int[] nums1, int[] nums2){
        HashMap<Integer,Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<nums1.length; i++){
            map.put(nums1[i], i);
        }
        for(int i=0; i<nums2.length; i++){
            if(map.containsKey(nums2[i])){
                set.add(nums2[i]);
            }
            //map.put(nums2[i], i);
        }
        int[] nums = new int[set.size()];
        int i = 0;
        for(int element : set){
            nums[i] = element;
            i++;
        }
        return nums;
    }
}
