package algorithm;

public class ThreeSumClosestTest {

    public static void main(String[] args) {

        invoke(1, new int[]{0, 0, 0, 0});
        invoke(2, new int[]{1});
        invoke(-99999, new int[]{-1, -1, 0, 2, 4, -3, 8, 17, 2, -5, -10, -7});
        invoke(3, new int[]{-1, -1, Integer.MAX_VALUE, Integer.MIN_VALUE, 1});
        invoke(14, new int[]{-1, 0, 1, 2, -1, -4, -1});
        invoke(1, new int[]{-1, 1, 2, -4});
        invoke(-52, new int[]{6,-18,-20,-7,-15,9,18,10,1,-20,-17,-19,-3,-5,-19,10,6,-11,1,-17,-15,6,17,-18,-3,16,19,-20,-3,-17,-15,-3,12,1,-9,4,1,12,-2,14,4,-4,19,-20,6,0,-19,18,14,1,-15,-5,14,12,-4,0,-10,6,6,-6,20,-8,-6,5,0,3,10,7,-2,17,20,12,19,-13,-1,10,-1,14,0,7,-3,10,14,14,11,0,-4,-15,-8,3,2,-5,9,10,16,-4,-3,-9,-8,-14,10,6,2,-12,-7,-16,-6,10});
    }

    private static void invoke(int target, int[] nums) {
        System.out.println(ThreeSumClosest.threeSumClosest(nums, target));
    }

}
