package algorithm;

import java.util.List;

public class ThreeSumTest {

    static int count = 0;

    public static void main(String[] args) {

        invoke(new int[]{0, 0, 0, 0});
        invoke(new int[]{1});
        invoke(new int[]{-1, -1, 0, 2, 4, -3, 8, 17, 2, -5, -10, -7});
        invoke(new int[]{-1, -1, Integer.MAX_VALUE, Integer.MIN_VALUE, 1});
        invoke(new int[]{-1, 0, 1, 2, -1, -4, -1});
    }

    private static List<List<Integer>> invoke(int[] nums) {
        System.out.println(String.format("-- -- set %s -- --", ++count));
        List<List<Integer>> l = ThreeSum.threeSum(nums);
        l.forEach(ll -> {
            ll.forEach(i -> System.out.print(i + " "));
            System.out.println();
        });
        System.out.println();
        return l;
    }

}
