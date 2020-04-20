package algorithm;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 56. 合并区间
 *
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 * 示例 2:
 *
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class MergeSeg {

    public static int[][] merge(int[][] inv) {
        if (inv == null || inv.length <= 1)
            return inv;
        Arrays.sort(inv, Comparator.comparingInt(i -> i[0]));

        int pos = 0, st = inv[0][0], ed = inv[0][1];

        for (int i = 1; i < inv.length; i++) {
            if (inv[i][0] <= ed) {
                ed = Math.max(inv[i][1], ed);
            } else {
                inv[pos][0] = st;
                inv[pos ++][1] = ed;
                st = inv[i][0];
                ed = inv[i][1];
            }
        }
        inv[pos][0] = st;
        inv[pos ++][1] = ed;

        return Arrays.copyOf(inv, pos);

    }



}
