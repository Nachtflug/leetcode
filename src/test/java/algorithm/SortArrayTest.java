package algorithm;

import java.util.Arrays;

public class SortArrayTest {


    public static void main(String[] args) {
        System.out.println(Arrays.toString(SortArray.sortArray(new int[]{5, 2, 3, 1})));
        System.out.println(Arrays.toString(SortArray.sortArray(new int[]{6, 6, 6, 7, 8, 9, 7, 8, 9, 1, 2, 3})));
        System.out.println(Arrays.toString(SortArray.sortArray(new int[]{5, 5, 5, 1})));
        System.out.println(Arrays.toString(SortArray.sortArray(new int[]{})));
        System.out.println(Arrays.toString(SortArray.sortArray(new int[]{1})));
        System.out.println(Arrays.toString(SortArray.sortArray(new int[]{6, 6, 6})));
    }
}
