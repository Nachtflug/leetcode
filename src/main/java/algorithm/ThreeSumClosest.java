package algorithm;

import java.util.Arrays;

/**
 * 最接近的三数之和
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 *
 * 双指针， 4ms
 */
public class ThreeSumClosest {

    public static int threeSumClosest(int[] nums, int target) {

        if (nums == null || nums.length < 3)
            return 0;
        Arrays.sort(nums);

        int closestDelta = target - nums[0] - nums[1] - nums[2];
        boolean minus = closestDelta < 0;
        if (minus) closestDelta = -closestDelta;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int rest = target - nums[i];
            int x = i + 1; int y = nums.length - 1;
            do {
                int delta = rest - nums[x] - nums[y];
                if (delta == 0)
                    return target;
                if (delta > 0) {
                    if (delta < closestDelta) {
                        closestDelta = delta;
                        minus = false;
                    }
                    x++;
                } else {
                    if (-delta < closestDelta) {
                        closestDelta = -delta;
                        minus = true;
                    }
                    y--;
                }
            } while (x < y);
        }
        return target + (minus ? closestDelta : -closestDelta);
    }


}
