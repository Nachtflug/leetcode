package algorithm;

import java.util.List;

/**
 *120. 三角形最小路径和难度中等457给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 *
 *
 *
 * 例如，给定三角形：
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 *
 *
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinimumTrianglePath {

    // dp
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()];
        for (List<Integer> line : triangle) {
            int size = line.size();
            dp[size - 1] = (size > 1 ? dp[size - 2] : 0) + line.get(size - 1);
            for (int i = size - 2; i >= 1; i--) {
                dp[i] = Math.min(dp[i], dp[i - 1]) + line.get(i);
            }
            if (size > 1)
                dp[0] = dp[0] + line.get(0);
        }
        int min = Integer.MAX_VALUE;
        for (int i : dp) {
            min = Math.min(min, i);
        }
        return min;
    }

}
