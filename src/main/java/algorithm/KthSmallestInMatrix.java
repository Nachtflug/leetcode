package algorithm;

import java.util.PriorityQueue;

/**
 * 378. 有序矩阵中第K小的元素难度中等275收藏分享切换为英文关注反馈给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
 *
 *
 *
 * 示例：
 *
 * matrix = [
 *    [ 1,  5,  9],
 *    [10, 11, 13],
 *    [12, 13, 15]
 * ],
 * k = 8,
 *
 * 返回 13。
 *
 *
 *
 *
 * 提示：
 * 你可以假设 k 的值永远是有效的，1 ≤ k ≤ n2 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class KthSmallestInMatrix {


    public static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        // 维护一个一维下标数组，指向各行目前的值
        // 根据题意，下标相等的情况下，数组越靠前的项，值越小，所以每次只用比较不同下标最靠前的
        int[] colIdx = new int[n];

        int ans = 0;
        while (k-- > 0) {
            int cans = Integer.MAX_VALUE;
            int minRow = 0, last = -1;
            for (int min = 0; min < n; min++) {
                if (colIdx[min] == last || colIdx[min] == -1)
                    continue;
                last = colIdx[min];
                if (matrix[min][colIdx[min]] < cans) {
                    minRow = min;
                    cans = matrix[min][colIdx[min]];
                }
            }
            ans = cans;
            if (++ colIdx[minRow] >= n)
                colIdx[minRow] = -1;
        }

        return ans;
    }


}
