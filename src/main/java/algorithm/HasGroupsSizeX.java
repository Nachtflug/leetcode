package algorithm;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * 914. 卡牌分组
 *
 * 给定一副牌，每张牌上都写着一个整数。
 *
 * 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
 *
 *     每组都有 X 张牌。
 *     组内所有的牌上都写着相同的整数。
 *
 * 仅当你可选的 X >= 2 时返回 true。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[1,2,3,4,4,3,2,1]
 * 输出：true
 * 解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
 *
 * 示例 2：
 *
 * 输入：[1,1,1,2,2,2,3,3]
 * 输出：false
 * 解释：没有满足要求的分组。
 *
 * 示例 3：
 *
 * 输入：[1]
 * 输出：false
 * 解释：没有满足要求的分组。
 */
public class HasGroupsSizeX {

    public static boolean hasGroupsSizeX(int[] deck) {
        return Arrays.stream(deck).boxed()
                .collect(Collectors.collectingAndThen(
                        Collectors.groupingBy(i -> i, Collectors.counting()),
                        m -> m.values().stream().distinct().reduce(
                                new long[]{-1, -1},
                                (p, l) -> new long[]{(l > 1 ? 1 : 0) & p[0] & ((p[1] ^ l) <= 0 || gcdGt1(l, p[1]) ? 1 : 0), l},
                                (p1, p2) -> new long[]{p1[0] & p2[0] & ((p1[1] ^ p2[1]) <= 0 || gcdGt1(p2[1], p1[1]) ? 1 : 0), Math.min(p1[1], p2[1])}
                                )))
                [0] == 1;
    }


    public static boolean gcdGt1(long a, long b) {
        if (b == 0)
            return a > 1;
        if (a < b) {
            return gcdGt1(a, b % a);
        } else
            return gcdGt1(b, a % b);
    }

}
