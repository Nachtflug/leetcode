package algorithm;

import java.util.Arrays;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置难度中等502收藏分享切换为英文关注反馈给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 *
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0)
            return new int[]{-1, -1};
        int lo = 0, hi = nums.length - 1, mid = 0;

        while (lo <= hi) {
            mid = lo + ((hi - lo) >> 1);
            if (nums[mid] == target)
                break;
            if (target > nums[mid])
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        if (lo == hi) {
            return new int[]{lo, hi};
        } else if (lo > hi) {
            return new int[]{-1, -1};
        }

        int tmp = mid;


        while (lo + 1 < mid) {
            int lMid = lo + ((mid - lo) >> 1);
            if (nums[lMid] == target)
                mid = lMid;
            else
                lo = lMid;
        }

        mid = tmp;
        while (hi - 1 > mid) {
            int hMid = mid + ((hi - mid) >> 1);
            if (nums[hMid] == target)
                mid = hMid;
            else
                hi = hMid;
        }
        return new int[]{nums[lo] == target ? lo : lo + 1, nums[hi] == target ? hi : hi - 1};
    }


    public static void main(String[] args) {


//        System.out.println(Arrays.toString(searchRange(new int[]{1, 2, 2,2,2,2,3,3,4}, 2)));
//        System.out.println(Arrays.toString(searchRange(new int[]{1, 2, 2,2,2,2,3,3,4}, 3)));
//        System.out.println(Arrays.toString(searchRange(new int[]{2}, 2)));
        System.out.println(Arrays.toString(searchRange(new int[]{2, 2}, 1)));
        System.out.println(Arrays.toString(searchRange(new int[]{2, 2, 2}, 2)));
        System.out.println(Arrays.toString(searchRange(new int[]{2, 2, 2, 2}, 2)));
    }

}
