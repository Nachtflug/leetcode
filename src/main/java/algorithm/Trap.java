package algorithm;

/**
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 */
public class Trap {

    public static int trap(int[] height) {

        if (height.length <= 2)
            return 0;
        int hIdx = 0, tIdx = height.length - 1, ret = 0;
        // 双指针，从左右向中间移动，直到相邻或相等
        while (hIdx < tIdx - 1) {
            int rocks = 0;
            // 每次选择短的一边移动
            if (height[hIdx] < height[tIdx])
                for (int i = hIdx + 1; i <= tIdx; i++) {
                    // 发现比当前边长时可以结算一次雨水面积
                    if (height[i] >= height[hIdx]) {
                        ret += height[hIdx] * (i - hIdx - 1) - rocks;
                        hIdx = i;
                        break;
                    // 否则累加低洼区域面积
                    } else
                        rocks += height[i];
                }
            else
                // 从右向左，类似的
                for (int i = tIdx - 1; i >= hIdx; i--) {
                    if (height[i] >= height[tIdx]) {
                        ret += height[tIdx] * (tIdx - i - 1) - rocks;
                        tIdx = i;
                        break;
                    } else
                        rocks += height[i];
                }
        }

        return ret;
    }

}
