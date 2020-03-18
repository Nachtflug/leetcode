package algorithm;


public class RectangleOverlapTest {


    public static void main(String[] args) {
        System.out.println(RectangleOverlap.isRectangleOverlap(new int[]{0, 0, 4, 4}, new int[]{1, 1, 5, 5}));
        System.out.println(RectangleOverlap.isRectangleOverlap(new int[]{0, 0, 4, 4}, new int[]{0, 4, 5, 5}));
    }


}
