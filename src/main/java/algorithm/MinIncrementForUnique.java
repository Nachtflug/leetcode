package algorithm;

import java.util.Arrays;

/**
 * 945. 使数组唯一的最小增量
 * 示例 1:
 *
 * 输入：[1,2,2]
 * 输出：1
 * 解释：经过一次 move 操作，数组将变为 [1, 2, 3]。
 */
public class MinIncrementForUnique {

    private static final int EFFECTIVE_LIMIT_LENGTH = 5000;

    public static int minIncrementForUnique(int[] a) {
        int move = 0;
        if (a.length < EFFECTIVE_LIMIT_LENGTH) {
            Arrays.sort(a);
            for (int i = 1; i < a.length; i++) {
                if (a[i] <= a[i - 1]) {
                    move += a[i - 1] - a[i] + 1;
                    a[i] = a[i - 1] + 1;
                }
            }
        } else {
            int max = -1, min = 50000;
            int[] count = new int[40001];
            for (int i : a) {
                count[i] ++;
                if (i > max)
                    max = i;
                else if (i < min)
                    min = i;
            }

            for (int i = min; i <= max; i++) {
                if (count[i] > 1) {
                    int step = count[i] - 1;
                    move += step;
                    count[i + 1] += step;
                }
            }
            int rest = count[max + 1] - 1;
            move += (rest + 1) * rest / 2;

        }

        return move;
    }

}
