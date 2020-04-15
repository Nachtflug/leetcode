package algorithm;

/**
 * 542. 01 矩阵
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
 *
 * 两个相邻元素间的距离为 1 。
 *
 * 示例 1:
 * 输入:
 *
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 输出:
 *
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 示例 2:
 * 输入:
 *
 * 0 0 0
 * 0 1 0
 * 1 1 1
 * 输出:
 *
 * 0 0 0
 * 0 1 0
 * 1 2 1
 * 注意:
 *
 * 给定矩阵的元素个数不超过 10000。
 * 给定矩阵中至少有一个元素是 0。
 * 矩阵中的元素只在四个方向上相邻: 上、下、左、右。
 */
public class UpdateMatrix {

    static int[] dix = new int[]{1, -1, 0, 0},
                 diy = new int[]{0, 0, 1, -1};


    //BFS
    public int[][] updateMatrix(int[][] matrix) {
        int height = matrix.length;
        if (height == 0) return matrix;
        int width = matrix[0].length;
        if (width == 0) return matrix;
        int pos = 0, distance = 2, total = height * width;
        int[] nextXs = new int[total],
              nextYs = new int[total],
              bakXs = new int[total],
              bakYs = new int[total];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    for (int k = 0; k < 4; k++) {
                        int dx = i + dix[k];
                        int dy = j + diy[k];
                        if (dx < 0 || dx >= height || dy < 0 || dy >= width) continue;
                        if (matrix[dx][dy] <= 0) continue;
                        nextXs[pos] = dx;
                        nextYs[pos] = dy;
                        pos ++;
                        matrix[dx][dy] = -1; //存负数，一来解决死循环，二来判断是否访问过就是当前值<=0;
                    }
                }
            }
        }

        while (pos > 0) {
            int newPos = 0;
            for (int i = 0; i < pos; i++) {
                int x = nextXs[i], y = nextYs[i];
                for (int k = 0; k < 4; k++) {
                    int dx = x + dix[k];
                    int dy = y + diy[k];
                    if (dx < 0 || dx >= height || dy < 0 || dy >= width) continue;
                    if (matrix[dx][dy] == 1) {
                        bakXs[newPos] = dx;
                        bakYs[newPos] = dy;
                        newPos++;
                        matrix[dx][dy] = -distance;
                    }
                }
            }
            distance ++;
            int[] tmp = nextXs;
            nextXs = bakXs;
            bakXs = tmp;
            tmp = nextYs;
            nextYs = bakYs;
            bakYs = tmp;
            pos = newPos;
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                matrix[i][j] *= -1;
            }
        }

        return matrix;
    }

}
