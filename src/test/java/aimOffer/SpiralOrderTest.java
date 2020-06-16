package aimOffer;

import java.util.Arrays;

public class SpiralOrderTest {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(

                SpiralOrder.spiralOrder(new int[][]{
                        new int[]{1, 2, 3},
                        new int[]{4, 5, 6},
                        new int[]{7, 8, 9}

                })
        ));


    }


}
