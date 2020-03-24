package algorithm;

public class FourSumTest {

    public static void main(String[] args) {
        System.out.println(FourSum.fourSum(new int[]{5,5,3,5,1,-5,1,-2}, 4));
        System.out.println(FourSum.fourSum(new int[]{-1,0,1,2,-1,-4}, -1));
        System.out.println(FourSum.fourSum(new int[]{0, 0, 0, 0}, 0));
        System.out.println(FourSum.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
        System.out.println(FourSum.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 999));
        System.out.println(FourSum.fourSum(new int[]{}, 0));
    }

}
