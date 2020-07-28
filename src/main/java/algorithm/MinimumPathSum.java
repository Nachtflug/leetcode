package algorithm;

/**
 * 64. 最小路径和难度中等562给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinimumPathSum {

    public int minPathSum(int[][] grid) {

        int m = grid.length;
        if (m == 0)
            return 0;
        int n = grid[0].length;
        for (int i = m - 2; i >= 0; i--) {
            grid[i][n - 1] += grid[i + 1][n - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            grid[m - 1][i] += grid[m - 1][i + 1];
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                grid[i][j] += Math.min(grid[i + 1][j], grid[i][j + 1]);
            }
        }

        return grid[0][0];
    }

}
