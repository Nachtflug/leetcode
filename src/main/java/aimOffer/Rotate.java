package aimOffer;

/**
 * 面试题 01.07. 旋转矩阵
 *
 * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
 *
 * 不占用额外内存空间能否做到？
 *
 *
 *
 * 示例 1:
 *
 * 给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 */
public class Rotate {

    public static void rotate(int[][] matrix) {

        int z = matrix.length;

        for (int i = 0; i < z >> 1; i++) {
            for (int j = i; j < z - 1 - i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[z - j - 1][i];
                matrix[z - j - 1][i] = matrix[z - i - 1][z - j - 1];
                matrix[z - i - 1][z - j - 1] = matrix[j][z - i - 1];
                matrix[j][z - i - 1] = tmp;
            }
        }

    }

}
