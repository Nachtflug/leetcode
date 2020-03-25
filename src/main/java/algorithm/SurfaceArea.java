package algorithm;

/**
 * 892. 三维形体的表面积
 *
 * 在 N * N 的网格上，我们放置一些 1 * 1 * 1  的立方体。
 *
 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
 *
 * 请你返回最终形体的表面积。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[[2]]
 * 输出：10
 *
 * 示例 2：
 *
 * 输入：[[1,2],[3,4]]
 * 输出：34
 */
public class SurfaceArea {
    /**
     * area = count * 6 - stickyCount * 2
     * @param grid
     * @return
     */
    public static int surfaceArea(int[][] grid) {
        
        int count = 0, stickyCount = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int cnt = grid[i][j];
                if (cnt == 0) continue;
                count += cnt;
                stickyCount += cnt - 1;
                if (i + 1 < grid.length) {
                    stickyCount += Math.min(cnt, grid[i + 1][j]);
                }
                if (j + 1 < grid[i].length) {
                    stickyCount += Math.min(cnt, grid[i][j + 1]);
                }
            }
        }

        return count * 6 - stickyCount * 2;
        
    }

}
