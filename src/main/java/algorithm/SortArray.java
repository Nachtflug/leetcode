package algorithm;

import java.util.Arrays;

/**
 * 912. 排序数组
 *
 * 给定一个整数数组 nums，将该数组升序排列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[5,2,3,1]
 * 输出：[1,2,3,5]
 */
public class SortArray {

    /**
     * 复习下快排
     * @param nums
     * @return
     */
    public static int[] sortArray(int[] nums) {
        if (nums == null)
            return null;
        int[] copy = Arrays.copyOf(nums, nums.length);
        if (copy.length <= 1)
            return copy;

        quickSort(copy, 0, nums.length - 1);

        return copy;
    }

    private static void quickSort(int[] nums, int from, int to) {
        if (from >= to) return;
        int benchMark = nums[from], st = from, ed = to;
        from ++;
        while (from < to) {
            if (nums[from] > benchMark)
                swap(nums, from, to--);
            else
                from ++;
        }
        int mid = nums[from] < benchMark ? from : from - 1;
        swap(nums, st, mid);

        quickSort(nums, st, mid - 1);
        quickSort(nums, mid + 1, ed);


    }


    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }



}
