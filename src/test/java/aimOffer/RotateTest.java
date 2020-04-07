package aimOffer;

import java.util.Arrays;

public class RotateTest {

    public static void main(String[] args) {
        int[][] matrix = {
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
                new int[]{7, 8, 9}
        };
        Rotate.rotate(matrix);

        System.out.println(Arrays.deepToString(matrix));
    }

}
