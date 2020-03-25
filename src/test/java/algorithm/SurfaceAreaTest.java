package algorithm;

public class SurfaceAreaTest {

    public static void main(String[] args) {
        System.out.println(SurfaceArea.surfaceArea(new int[][]{new int[]{1, 0}, new int[]{0, 2}})); //10
        System.out.println(SurfaceArea.surfaceArea(new int[][]{new int[]{2}})); //10
        System.out.println(SurfaceArea.surfaceArea(new int[][]{new int[]{2, 2, 2}, new int[]{2, 1, 2}, new int[]{2, 2, 2}})); //10
        System.out.println(SurfaceArea.surfaceArea(new int[][]{new int[]{}})); //10

    }

}
