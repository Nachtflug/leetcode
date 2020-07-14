package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class IntersectionOfTwoArraysII {

    public static int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer, Integer> num2cnt = new HashMap<>();
        for (int i : nums1) {
            num2cnt.compute(i, (k, v) -> v == null ? 1 : v + 1);
        }

        ArrayList<Integer> arrList = new ArrayList<>();
        for (int i : nums2) {
            if (num2cnt.get(i) != null) {
                arrList.add(i);
                num2cnt.compute(i, (k, v) -> v == 1 ? null : v - 1);
            }
        }

        return arrList.stream().mapToInt(Integer::intValue).toArray();
    }

}
