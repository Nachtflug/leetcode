package algorithm;

public class MaxDistanceToLandTest {

    public static void main(String[] args) {
        System.out.println(MaxDistanceToLand.maxDistance(new int[][]{
                new int[]{1, 0, 1},
                new int[]{0, 0, 0},
                new int[]{1, 0, 1}
        }));
        System.out.println(MaxDistanceToLand.maxDistance(new int[][]{
                new int[]{0, 0, 0},
                new int[]{0, 0, 0},
                new int[]{0, 0, 1}
        }));
        System.out.println(MaxDistanceToLand.maxDistance(new int[][]{
                new int[]{0, 0, 0}
        }));
        System.out.println(MaxDistanceToLand.maxDistance(new int[][]{
                new int[]{1, 1, 1}
        }));
    }

}
