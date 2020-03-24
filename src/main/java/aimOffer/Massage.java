package aimOffer;

/**
 * 面试题 17.16. 按摩师
 *
 * 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。
 * 给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
 *
 * 注意：本题相对原题稍作改动
 *
 *
 *
 * 示例 1：
 *
 * 输入： [1,2,3,1]
 * 输出： 4
 * 解释： 选择 1 号预约和 3 号预约，总时长 = 1 + 3 = 4。
 *
 * 示例 2：
 *
 * 输入： [2,7,9,3,1]
 * 输出： 12
 * 解释： 选择 1 号预约、 3 号预约和 5 号预约，总时长 = 2 + 9 + 1 = 12。
 *
 * 示例 3：
 *
 * 输入： [2,1,4,5,3,1,1,3]
 * 输出： 12
 * 解释： 选择 1 号预约、 3 号预约、 5 号预约和 8 号预约，总时长 = 2 + 4 + 3 + 3 = 12。
 */
public class Massage {

    /**
     * 选完第i个以后，要么选第i+2个，要么选i+3, 选i+4肯定比选i+2亏, 因为选了i+2还能选i+4，反之亦然
     * 并且，余下部分的最大值可以dp，所以只用逆向走一次即可O(n)
     * 状态转移方程
     * max[i] = nums[i] + MAX{max{i + 2}, max{i + 3}}
     * @param nums
     * @return
     */
    public static int massage(int[] nums) {
        final int size = nums.length;
        if (size == 0) return 0;
        if (size == 1) return nums[0];
        int[] max = new int[size];

        for (int i = size - 1; i >= 0; i--) {
            int a = i + 2 >= size ? 0 : max[i + 2];
            int b = i + 3 >= size ? 0 : max[i + 3];
            max[i] = nums[i] + Math.max(a, b);
        }

        return Math.max(max[0], max[1]);
    }

}
