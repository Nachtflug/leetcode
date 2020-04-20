package algorithm;

/**
 * 200. 岛屿数量
 *
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 * 示例 1:
 *
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 输出: 1
 *
 * 示例 2:
 *
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * 输出: 3
 * 解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
 */
public class CountIslands {

    private static int[] dirX = new int[]{1, -1, 0, 0};
    private static int[] dirY = new int[]{0, 0, 1, -1};

    public int numIslands(char[][] grid) {
        int cnt = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                char cur = grid[i][j];
                if (cur == '1') {
                    cnt ++;
                    flap(grid, i, j); //翻格子
                }
                grid[i][j] = 'D';
            }
        }

        return cnt;
    }

    private void flap(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] != '1') return;

        grid[i][j] = 'D';

        for (int k = 0; k < 4; k++) {
            flap(grid, i + dirX[k], j + dirY[k]);
        }

    }

}
