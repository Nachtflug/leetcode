package algorithm;

import java.util.*;

/**
 * 18. 四数之和
 *
 */
public class FourSum {

    /**
     * 直接套用 三数之和 + 外层循环是可以的，但是未免枯燥
     *
     * 四数可以分成两组，每组又是两数之和，为了避免重复以及数字重复利用，维护四个指针(i, j, x, y)
     *
     * 指针之间有严格的大小顺序， 当前两个指针向后移动时，第三个指针的移动范围就会缩小
     *
     * 第三个指针之后，所有两个数的组合是确定的，这里可以dp，保存所有组合，从而加快搜索
     *
     * {tuple}(x) = {tuple}(x + 1) ++ {nums[x] * nums[x + 1, ]}
     *
     * 当然排序能够很好地优化逻辑，帮助去重
     *
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {


        ArrayList<List<Integer>> ret = new ArrayList<>();

        if (nums.length < 4) {
            return ret;
        }

        Arrays.sort(nums);

        @SuppressWarnings("unchecked")
        HashMap<Integer, List<int[]>>[] dp = new HashMap[nums.length];
        dp[nums.length - 1] = new HashMap<>();
        boolean continueSame = false;
        for (int x = nums.length - 2; x >= 2; x--) {
            HashMap<Integer, List<int[]>> cur = new HashMap<>();
            // 构造方法是浅拷贝
            dp[x + 1].forEach((k, v) -> cur.put(k, new ArrayList<>(v)));
            dp[x] = cur;
            if (nums[x] == nums[x + 1]) {
                if (continueSame)
                    continue;
                else {
                    int key = nums[x] * 2;
                    cur.computeIfAbsent(key, k -> new ArrayList<>()).add(new int[]{nums[x], nums[x]});
                    continueSame = true;
                    continue;
                }
            }
            continueSame = false;
            for (int y = x + 1; y < nums.length; y++) {
                if (y > x + 1 && nums[y] == nums[y - 1])
                    continue;
                int sum = nums[x] + nums[y];
                cur.computeIfAbsent(sum, k -> new ArrayList<>()).add(new int[]{nums[x], nums[y]});
            }
        }


        for (int i = 0; i <= nums.length - 4; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j <= nums.length - 3; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                int rest = target - nums[i] - nums[j];
                if (rest < nums[j] * 2)
                    break;
                List<int[]> tuples = dp[j + 1].get(rest);
                if (tuples != null) {
                    for (int[] tuple : tuples) {
                        ret.add(Arrays.asList(nums[i], nums[j], tuple[0], tuple[1]));
                    }
                }

            }
        }

        return ret;
    }


}
