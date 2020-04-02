package algorithm;

import java.util.Arrays;

public class GameOfLifeTest {

    public static void main(String[] args) {
        int[][] b = new int[][] {
                new int[]{0, 1, 0},
                new int[]{0, 0, 1},
                new int[]{1, 1, 1},
                new int[]{0, 0, 0}
        };
        GameOfLife.gameOfLife(b);
        System.out.println(Arrays.deepToString(b));
    }
}
