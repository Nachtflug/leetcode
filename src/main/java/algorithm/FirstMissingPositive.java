package algorithm;

/**
 * 41. 缺失的第一个正数
 * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 *
 * 输入: [7,8,9,11,12]
 * 输出: 1
 *
 *
 * 提示：
 *
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。
 */
public class FirstMissingPositive {

    public static int firstMissingPositive(int[] nums) {

        int max = nums.length;

        for (int i = 0; i < nums.length; i++) {
            while (true) {
                int val = nums[i];
                if (val == i + 1)
                    break;
                else if (val <= 0 || val > max) {
                    nums[i] = 0;
                    break;
                } else if (nums[val - 1] == val)
                    break;
                else
                    swap(nums, i, val - 1);

            }

        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i + 1)
                continue;
            return i + 1;
        }
        return max + 1;
    }


    public static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {

        System.out.println(firstMissingPositive(new int[]{1,1}));

    }

}
