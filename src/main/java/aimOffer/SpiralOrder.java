package aimOffer;

public class SpiralOrder {

    public static int[] spiralOrder(int[][] matrix) {
        int[][] directions = new int[][]{
                new int[]{0, 1, 0, 1}, new int[]{1, 0, 3, -1},
                new int[]{0, -1, 2, -1}, new int[]{-1, 0, 1, 1}
        };
        int h = matrix.length;
        if (h == 0)
            return new int[]{};
        int w = matrix[0].length;
        int[] bound = new int[]{0, 0, h, w};

        int x = 0, y = 0;
        int idx = 0, i = 0;
        int[] ret = new int[w * h];

        while (bound[0] != bound[2] && bound[1] != bound[3]) {
            int[] d = directions[idx % 4];
            while (bound[0] <= x && x < bound[2] && bound[1] <= y && y < bound[3]) {
                ret[i] = matrix[x][y];
                x += d[0];
                y += d[1];
                i++;
            }
            idx ++;
            x += directions[idx % 4][0] - d[0];
            y += directions[idx % 4][1] - d[1];
            bound[d[2]] += d[3];
        }

        return ret;

    }
}
