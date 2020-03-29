package algorithm;

/**
 * 1162. 地图分析
 * 你现在手里有一份大小为 N x N 的『地图』（网格） grid，上面的每个『区域』（单元格）都用 0 和 1 标记好了。其中 0 代表海洋，1 代表陆地，你知道距离陆地区域最远的海洋区域是是哪一个吗？请返回该海洋区域到离它最近的陆地区域的距离。
 *
 * 我们这里说的距离是『曼哈顿距离』（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个区域之间的距离是 |x0 - x1| + |y0 - y1| 。
 *
 * 如果我们的地图上只有陆地或者海洋，请返回 -1。
 *
 *
 *
 * 输入：[[1,0,1],[0,0,0],[1,0,1]]
 * 输出：2
 * 解释：
 * 海洋区域 (1, 1) 和所有陆地区域之间的距离都达到最大，最大距离为 2。
 */
public class MaxDistanceToLand {

    private static final int[][] DIRECTIONS = new int[][]{
            new int[]{-1, 0},
            new int[]{1, 0},
            new int[]{0, -1},
            new int[]{0, 1}
    };

    /**
     * BFS 每一步扩大一圈陆地，直到全部填成陆地，步数就是最大距离
     * @param grid
     * @return
     */
    public static int maxDistance(int[][] grid) {
        int height = grid.length;
        int width = grid[0].length;
        int total = height * width;
        int[] nextLands = new int[total], swapCache = new int[total];
        int ptr = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == 1)
                    nextLands[ptr++] = i * width + j;
            }
        }
        if (ptr == total)
            return -1;
        int step = -1;
        while (ptr > 0) {
            int p = 0;
            for (int i = 0; i < ptr; i++) {
                int x = nextLands[i] / width;
                int y = nextLands[i] % height;
                for (int[] d : DIRECTIONS) {
                    int dx = x + d[0], dy = y + d[1];
                    if (dx >= 0 && dx < height && dy >= 0 && dy < width && grid[dx][dy] == 0) {
                        grid[dx][dy] = 1;
                        swapCache[p++] = dx * width + dy;
                    }
                }
            }
            ptr = p;
            int[] temp = nextLands;
            nextLands = swapCache;
            swapCache = temp;
            step ++;
        }
        return step;
    }

}
