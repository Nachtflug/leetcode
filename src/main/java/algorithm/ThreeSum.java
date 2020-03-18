package algorithm;

import java.util.*;

/**
 * 15. 三数之和
 */
public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> ret = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return ret;
        }
        Map<Integer, Integer> vIdx = new HashMap<>(nums.length);
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++)
            vIdx.put(nums[i], i);

        for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                int rest = - nums[i] - nums[j];
                if (rest < nums[j])
                    break;
                Integer idx = vIdx.get(rest);
                if (idx != null && idx > j) {
                    ret.add(wrap(nums[i], nums[j], rest));
                }
            }
        }

        return ret;
    }

    private static List<Integer> wrap(int num, int num1, int rest) {
        List<Integer> l = new ArrayList<>();
        l.add(num);
        l.add(num1);
        l.add(rest);
        return l;
    }


}
