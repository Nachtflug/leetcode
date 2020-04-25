package algorithm;

import java.util.Arrays;

public class MergeSegTest {

    public static void main(String[] args) {

        System.out.println(Arrays.deepToString(MergeSeg.merge(new int[][]{
                new int[]{1, 2}, new int[]{2, 3}, new int[]{1, 5}, new int[]{10, 100}
        })));
        System.out.println(Arrays.deepToString(MergeSeg.merge(new int[][]{
                new int[]{1, 2}, new int[]{3, 4}, new int[]{7, 9}, new int[]{1, 100}
        })));
    }

}
